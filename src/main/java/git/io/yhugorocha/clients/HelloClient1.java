package git.io.yhugorocha.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(baseUri="http://localhost:8080")
@Path("/hello")
public interface HelloClient1 {

    @GET
    String hello();
}
