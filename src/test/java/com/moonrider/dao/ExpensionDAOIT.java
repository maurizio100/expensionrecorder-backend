package com.moonrider.dao;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.moonrider.dto.ExpenseDTO;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ExpensionDAOIT {

	@Inject
	private ExpenseDAO expenseDAO;
	
	
	@Test
	public void listExpenses_shouldReturn_expenses() {
		List<ExpenseDTO> result = expenseDAO.getExpenses();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), greaterThan(0));
	}
}
