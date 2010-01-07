package org.expressme.webwind.demo.tx;

import java.sql.Connection;

public class TxHolder {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static void setCurrentConnection(Connection connection) {
        threadLocal.set(connection);
    }

    public static Connection getCurrentConnection() {
        return threadLocal.get();
    }

    public static void removeCurrentConnection() {
        threadLocal.remove();
    }
}
