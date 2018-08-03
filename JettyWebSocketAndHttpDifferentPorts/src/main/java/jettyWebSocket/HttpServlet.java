package jettyWebSocket;

import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Well, it's just a servlet declaration.
 *
 * @author heucles.junior
 */
@ApplicationPath("rest")
public class HttpServlet extends Application {

    public HttpServlet(){

    }

    @Override
    public Set<Class<?>> getClasses() {
       return ImmutableSet.<Class<?>>builder()
               .add(JacksonFeature.class)
               .add(JacksonJaxbJsonProvider.class).build();

    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "jettyWebSocket.http");

        return properties;
    }


}
