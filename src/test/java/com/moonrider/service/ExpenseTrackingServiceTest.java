package com.moonrider.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.moonrider.dao.ExpenseDAO;


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
		expenseTrackingService.getExpenses();		
		verify(expenseDAO, times(1)).getExpenses();
	}
}
