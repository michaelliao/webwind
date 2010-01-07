package org.expressme.webwind.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.expressme.webwind.demo.Post;
import org.expressme.webwind.demo.tx.TxHolder;

public class DbUtils {

    public static final String FIRST_POST_TITLE = "My first blog post";
    public static final String FIRST_POST_CONTENT = "Hello, this is my first blog post!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:test", "sa", "");
    }

    private static long nextId;

    public static long nextId() {
        nextId++;
        return nextId;
    }

    public static void initDb() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        }
        catch(ClassNotFoundException e) {
            throw new NoClassDefFoundError("org.hsqldb.jdbcDriver");
        }
        Connection conn = getConnection();
        execute(conn, "drop table Post if exists");
        execute(conn, "create table Post (id bigint primary key, title varchar(50) not null, content varchar(2000) not null, creation date not null)");
        execute(conn, "insert into Post (id, title, content, creation) values(?, ?, ?, ?)", 0, FIRST_POST_TITLE, FIRST_POST_CONTENT, new Date());
        conn.close();
    }

    static void execute(Connection conn, String sql, Object... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0; i<args.length; i++) {
            Object o = args[i];
            ps.setObject(i+1, o);
        }
        ps.executeUpdate();
        ps.close();
    }

    public static List<Post> queryForList(String sql, Object... args) throws Exception {
        Connection conn = TxHolder.getCurrentConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> list = new ArrayList<Post>();
        try {
            ps = conn.prepareStatement(sql);
            bindParameters(ps, args);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("creation"));
                list.add(post);
            }
            return list;
        }
        finally {
            close(rs);
            close(ps);
        }
    }

    public static int executeUpdate(String sql, Object... args) throws Exception {
        Connection conn = TxHolder.getCurrentConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            bindParameters(ps, args);
            return ps.executeUpdate();
        }
        finally {
            close(ps);
        }
    }

    static void bindParameters(PreparedStatement ps, Object... args) throws Exception {
        for (int i=0; i<args.length; i++) {
            ps.setObject(i+1, args[i]);
        }
    }

    static void close(PreparedStatement ps) {
        if (ps!=null) {
            try {
                ps.close();
            }
            catch (SQLException e) {}
        }
    }

    static void close(ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            }
            catch (SQLException e) {}
        }
    }
}
