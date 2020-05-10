package com.moonrider.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.moonrider.dao.ExpenseDAO;
import com.moonrider.dto.ExpenseDTO;

@ApplicationScoped
public class ExpenseTrackingServiceImpl implements ExpenseTrackingService {

	final ExpenseDAO expenseDAO;
	
	@Inject
	public ExpenseTrackingServiceImpl(ExpenseDAO expenseDAO) {
		this.expenseDAO = expenseDAO;
	}
	
	@Override
	public List<ExpenseDTO> getExpenses() {
		return expenseDAO.getExpenses();
	}

	
}
