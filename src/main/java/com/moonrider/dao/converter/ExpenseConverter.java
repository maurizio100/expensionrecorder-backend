package com.moonrider.dao.converter;

import javax.enterprise.context.Dependent;

import com.moonrider.dao.dto.ExpenseDTO;
import com.moonrider.dao.dto.ExpenseDTO.ExpenseDTOBuilder;
import com.moonrider.domain.Expense;

@Dependent
public class ExpenseConverter {

	public ExpenseDTO convert(Expense expense) {
		return new ExpenseDTOBuilder(expense).build();
	}
	
}
