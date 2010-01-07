package org.expressme.webwind.demo.tx;

import java.sql.Connection;
import java.sql.DriverManager;

import org.expressme.webwind.Execution;
import org.expressme.webwind.Interceptor;
import org.expressme.webwind.InterceptorChain;
import org.expressme.webwind.InterceptorOrder;

/**
 * Transaction interceptor.
 */
@InterceptorOrder(1)
public class TxInterceptor implements Interceptor {

    public void intercept(Execution execution, InterceptorChain chain) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sa", "");
        connection.setAutoCommit(false);
        try {
            TxHolder.setCurrentConnection(connection);
            chain.doInterceptor(execution);
            connection.commit();
        }
        catch (Exception e) {
            connection.rollback();
            throw e;
        }
        finally {
            TxHolder.removeCurrentConnection();
        }
    }
}
