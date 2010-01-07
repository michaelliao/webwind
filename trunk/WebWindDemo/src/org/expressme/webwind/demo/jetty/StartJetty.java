package org.expressme.webwind.demo.jetty;

import org.expressme.webwind.demo.util.DbUtils;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Start Jetty as embeded server.
 */
public class StartJetty {

    static final int PORT = 8990;

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        startServer(server);
        Runtime.getRuntime().exec("cmd.exe /C start http://localhost:" + PORT);
        server.join();
        stopServer(server);
    }

    static void startServer(Server server) throws Exception {
        DbUtils.initDb();
        Connector connector = new SelectChannelConnector();
        connector.setPort(PORT);
        server.setConnectors(new Connector[] { connector });
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("webwind-demo.war");
        server.setHandler(webapp);
        server.start();
        while (!server.isRunning());
    }

    static void stopServer(Server server) {
        try {
            server.stop();
            while (!server.isStopped());
        }
        catch (Exception e) {}
    }
}
