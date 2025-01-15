package git.io.yhugorocha.service;

import git.io.yhugorocha.entities.Expense;
import git.io.yhugorocha.repository.ExpenseRepository;
import git.io.yhugorocha.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class ExpenseService {

    @Inject
    PersonRepository personRepository;

    @Inject
    ExpenseRepository expenseRepository;

    @Transactional
    public Expense created(Expense expense){
        var person = personRepository.findByIdOptional(expense.getPersonId())
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
        expense.setPerson(person);
        expenseRepository.persist(expense);
        return expense;
    }

    public List<Expense> findAll(){
        return expenseRepository.findAll().list();
    }
}
