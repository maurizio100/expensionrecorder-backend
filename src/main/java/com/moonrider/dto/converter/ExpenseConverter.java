package com.moonrider.dto.converter;

import javax.enterprise.context.Dependent;

import com.moonrider.domain.Expense;
import com.moonrider.dto.ExpenseDTO;
import com.moonrider.dto.ExpenseDTO.ExpenseDTOBuilder;

@Dependent
public class ExpenseConverter {

	public ExpenseDTO convert(Expense expense) {
		return new ExpenseDTOBuilder(expense).build();
	}
	
}
