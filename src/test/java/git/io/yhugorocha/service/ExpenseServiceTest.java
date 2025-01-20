package git.io.yhugorocha.service;

import git.io.yhugorocha.repository.ExpenseRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

@QuarkusTest
class ExpenseServiceTest {

    @Inject
    ExpenseService expenseService;

    @InjectMock
    ExpenseRepository expenseRepository;

    @Test
    void testExpenseService(){
        Mockito.when(expenseRepository.findAll().list()).thenReturn(Collections.emptyList());
    }
}