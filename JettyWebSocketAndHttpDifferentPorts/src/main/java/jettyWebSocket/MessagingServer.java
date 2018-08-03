package jettyWebSocket;

import jettyWebSocket.http.HttpHelloWorld;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * The executable main class.
 * @author heucles.junior
 */
public class MessagingServer {

    private Server server;

    public void setup() {

        server = new Server();
        ServerConnector httpConnector = new ServerConnector(server);
        httpConnector.setPort(8081);
        httpConnector.setName("HTTP");
        server.addConnector(httpConnector);

        ServletContextHandler httpHandlerContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        httpHandlerContext.setContextPath("/");
        //server.setHandler(httpHandlerContext);

        ServletHolder servletHolder = httpHandlerContext.addServlet(ServletContainer.class, "/rest/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("javax.ws.rs.Application", "jettyWebSocket.HttpServlet");
        httpHandlerContext.setVirtualHosts(new String[]{"@HTTP"});

        ServerConnector webSocketConnector = new ServerConnector(server);
        webSocketConnector.setPort(8080);
        webSocketConnector.setName("WebSocket");
        server.addConnector(webSocketConnector);

        ServletContextHandler webSocketHandlerContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        webSocketHandlerContext.setContextPath("/");
       //server.setHandler(webSocketHandlerContext);

        webSocketHandlerContext.addServlet(MessagingServlet.class, "/messaging");
        
        ContextHandlerCollection contexts = new ContextHandlerCollection();

        contexts.setHandlers(new Handler[] {
                httpHandlerContext,
                webSocketHandlerContext});

        server.setHandler(contexts);





    }

    public void start() throws Exception {
        server.start();
        server.dump(System.err);
        server.join();
    }

    public static void main(String args[]) throws Exception {
        MessagingServer theServer = new MessagingServer();
        theServer.setup();
        theServer.start();
    }
}

//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.ServerConnector;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//
//
//public class MessagingServer {
//
//    private Server server;
//
//    public void setup() {
//        server = new Server();
//        ServerConnector connector = new ServerConnector(server);
//        connector.setPort(8080);
//        server.addConnector(connector);
//
//        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        handler.setContextPath("/");
//        server.setHandler(handler);
//
//        handler.addServlet(MessagingServlet.class, "/messaging");
//    }
//
//    public void start() throws Exception {
//        server.start();
//        server.dump(System.err);
//        server.join();
//    }
//
//    public static void main(String args[]) throws Exception {
//        MessagingServer theServer = new MessagingServer();
//        theServer.setup();
//        theServer.start();
//    }
//}

