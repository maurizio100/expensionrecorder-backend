package com.moonrider.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.moonrider.dao.ExpenseDAO;
import com.moonrider.dao.dto.ExpenseDTO;

@ApplicationScoped
public class ExpenseTrackingService {

	final ExpenseDAO expenseDAO;
	
	@Inject
	public ExpenseTrackingService(ExpenseDAO expenseDAO) {
		this.expenseDAO = expenseDAO;
	}
	
	public List<ExpenseDTO> getExpenses() {
		return expenseDAO.getExpenses();
	}

	
}
