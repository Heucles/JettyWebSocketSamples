//package jettyWebSocket;
//
//import jettyWebSocket.http.HttpHelloWorld;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.ServerConnector;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.servlet.ServletContainer;
//
//import javax.ws.rs.core.UriBuilder;
//import java.net.URI;
//
///**
// * The executable main class.
// * @author heucles.junior
// */
//public class MessagingServerBkp {
//
//    private Server server;
//
//    public void setup() {
//        ResourceConfig config = new ResourceConfig(HttpHelloWorld.class);
//        URI baseUri = UriBuilder.fromUri("http://localhost").port(8081).build();
////        server = JettyHttpContainerFactory.createServer(baseUri, config,
////                false);
//        server = new Server();
////
//
//
//        ServerConnector connectorWebSocket = new ServerConnector(server);
//        connectorWebSocket.setPort(8080);
//        server.addConnector(connectorWebSocket);
//
//        ServletContextHandler webSocketHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        webSocketHandler.setContextPath("/");
//        server.setHandler(webSocketHandler);
//
//        webSocketHandler.addServlet(MessagingServlet.class, "/messaging");
//
//
//
//
//        ServerConnector connectorWeb = new ServerConnector(server);
//        connectorWeb.setPort(8081);
//        server.addConnector(connectorWeb);
//
//        ServletContextHandler httpHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        httpHandler.setContextPath("/");
//        server.setHandler(httpHandler);
//
//        ServletHolder servletHolder = httpHandler.addServlet(ServletContainer.class, "/rest/*");
//        servletHolder.setInitOrder(0);
//        servletHolder.setInitParameter("javax.ws.rs.Application", "jettyWebSocket.HttpServlet");
//
//    }
//
//    public void start() throws Exception {
//        server.start();
//        server.dump(System.err);
//        server.join();
//    }
//
//    public static void main(String args[]) throws Exception {
//        MessagingServerBkp theServer = new MessagingServerBkp();
//        theServer.setup();
//        theServer.start();
//    }
//}
//
////import org.eclipse.jetty.server.Server;
////import org.eclipse.jetty.server.ServerConnector;
////import org.eclipse.jetty.servlet.ServletContextHandler;
////
////
////public class MessagingServer {
////
////    private Server server;
////
////    public void setup() {
////        server = new Server();
////        ServerConnector connector = new ServerConnector(server);
////        connector.setPort(8080);
////        server.addConnector(connector);
////
////        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
////        handler.setContextPath("/");
////        server.setHandler(handler);
////
////        handler.addServlet(MessagingServlet.class, "/messaging");
////    }
////
////    public void start() throws Exception {
////        server.start();
////        server.dump(System.err);
////        server.join();
////    }
////
////    public static void main(String args[]) throws Exception {
////        MessagingServer theServer = new MessagingServer();
////        theServer.setup();
////        theServer.start();
////    }
////}
//
