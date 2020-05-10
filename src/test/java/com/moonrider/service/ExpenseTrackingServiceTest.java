package com.moonrider.service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.moonrider.dao.ExpenseDAO;
import com.moonrider.dto.ExpenseDTO;
import com.moonrider.dto.ExpenseDTO.ExpenseDTOBuilder;


public class ExpenseTrackingServiceTest {


	@Mock private ExpenseDAO expenseDAO;
	private ExpenseTrackingService expenseTrackingService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		expenseTrackingService = new ExpenseTrackingServiceImpl(expenseDAO);
	}
	
	
	@Test
	public void getExpenses_shouldCallExpenseDAO() {
		when(expenseDAO.getExpenses()).thenReturn(List.of(new ExpenseDTOBuilder().build()));
		List<ExpenseDTO> expenses = expenseTrackingService.getExpenses();
		
		assertThat(expenses.isEmpty(), is(false));
		verify(expenseDAO, times(1)).getExpenses();
	}
	
	@Test
	public void getExpenses_returnsEmptyList() {
		when(expenseDAO.getExpenses()).thenReturn(Collections.emptyList());
		List<ExpenseDTO> expenses = expenseTrackingService.getExpenses();
		
		assertThat(expenses.isEmpty(), is(true));
	}
	
	@Test
	public void getExpenses_returnFilledList() {
		when(expenseDAO.getExpenses()).thenReturn(List.of(new ExpenseDTOBuilder().build()));
		List<ExpenseDTO> expenses = expenseTrackingService.getExpenses();
		
		assertThat(expenses.isEmpty(), is(false));
		assertThat(expenses.size(), is(1));
	}
}
