package git.io.yhugorocha.resources;

import git.io.yhugorocha.entities.Person;
import git.io.yhugorocha.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id){
        var person = personRepository.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));

        return Response.ok(person).build();
    }
}
