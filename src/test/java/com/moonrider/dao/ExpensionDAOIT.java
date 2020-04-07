package com.moonrider.dao;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;


import com.moonrider.dao.dto.ExpenseDTO;
import com.moonrider.domain.Expense;
import com.moonrider.domain.Expense.ExpenseBuilder;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExpensionDAOIT {

	@Inject
	private ExpenseDAO expenseDAO;
	
	@Inject
	private EntityManager em;
	
	
	@Test
	public void listExpenses_shouldReturn_expenses() {
		List<ExpenseDTO> result = expenseDAO.getExpenses();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), greaterThan(0));
	}
	
	@Test
	@Transactional
	public void listExpenses_shouldReturn_expensesWithDefaults() {
		Expense testExpense = new ExpenseBuilder()
			.name("Testexpense")
			.price(new BigDecimal(50.0))
			.expenseDate(LocalDate.now())
			.build();
		
		em.persist(testExpense);
		Long expenseId = testExpense.getExpenseId();
		
		
		List<ExpenseDTO> result = expenseDAO.getExpenses();
		Optional<ExpenseDTO> dtoOptional = result.stream().filter(e -> e.getExpenseId() == expenseId).findFirst();
		
		assertThat(dtoOptional.isPresent(), is(true));
		
		ExpenseDTO expenseDTO = dtoOptional.get();
		assertThat(expenseDTO.getPrice(), notNullValue());
		assertThat(expenseDTO.getDescription(), nullValue());
	}	
}
