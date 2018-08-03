package jettyWebSocket.http;

/**
 * @author heucles.junior
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/helloWorld")
public class HttpHelloWorld {

    @GET
    @Path("/")
    public String helloWorld() {
        return "Hello World";
    }
}