package git.io.yhugorocha.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "hello-api")
@Path("/hello")
public interface HelloClient2 {

    @GET
    String hello();
}

