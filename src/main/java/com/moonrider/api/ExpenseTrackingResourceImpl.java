package com.moonrider.api;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.moonrider.dto.ExpenseDTO;
import com.moonrider.service.ExpenseTrackingService;


@ApplicationScoped
public class ExpenseTrackingResourceImpl implements ExpenseTrackingResource {

	private final ExpenseTrackingService expenseTrackingService;
	
	@Inject
	public ExpenseTrackingResourceImpl(ExpenseTrackingService expenseTrackingService) {
		this.expenseTrackingService = expenseTrackingService;
	}


	@Override
	public List<ExpenseDTO> list() {
		return expenseTrackingService.getExpenses();
	}
}
