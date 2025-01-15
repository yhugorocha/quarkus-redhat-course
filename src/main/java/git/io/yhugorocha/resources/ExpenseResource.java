package git.io.yhugorocha.resources;

import git.io.yhugorocha.entities.Expense;
import git.io.yhugorocha.service.ExpenseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/expenses")
public class ExpenseResource {

    @Inject
    ExpenseService expenseService;

    @POST
    public Response create(Expense expense){
        return Response.ok(expenseService.created(expense)).build();
    }

    @GET
    public Response getAll(){
        return Response.ok(expenseService.findAll()).build();
    }
}
