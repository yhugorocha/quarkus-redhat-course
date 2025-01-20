package git.io.yhugorocha.resources;

import git.io.yhugorocha.clients.HelloClient1;
import git.io.yhugorocha.configs.ExampleConfiguration;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/example")
public class ExampleResource {

    @Inject
    ExampleConfiguration configuration;

    @RestClient
    HelloClient1 helloClient1;

    @ConfigProperty(name = "textHello")
    String msgHello;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConfig(){

        List<String> listConfig = new ArrayList<>();
        listConfig.add(configuration.user().username());
        listConfig.add(configuration.user().email());

        return Response.ok(listConfig).build();
    }

    @GET
    @Path("/environment/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnvironmentVariable(){
        return Response.ok(msgHello).build();
    }

    @GET
    @Path("/client")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Faz uma chamada a outra API", operationId = "createExpense")
    @APIResponse(
            responseCode = "200",
            headers = {
            @Header(
                    schema = @Schema(implementation = String.class)
            ),
    },
            description = "Chamada feita com sucesso"
    )
    public Response getClient(){

        return Response.ok(helloClient1.hello()).build();
    }

}
