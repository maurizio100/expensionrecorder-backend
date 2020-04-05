package com.moonrider.dto;

import com.moonrider.domain.Expense;
import com.moonrider.dto.ExpenseDTO.ExpenseDTOBuilder;

public class ExpenseFactory {
	
	public ExpenseDTO createExpenseDTO(Expense expense) {
		return new ExpenseDTOBuilder().build();
	}
	
}
