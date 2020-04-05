package com.moonrider.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDTO {
	
	private final Long expenseId;
	private final String name;
	private final String description;
	private final LocalDate expenseDate;
	private final BigDecimal price;
	
	public ExpenseDTO(Long expenseId, String name, String description, LocalDate expenseDate, BigDecimal price) {
		super();
		this.expenseId = expenseId;
		this.name = name;
		this.description = description;
		this.expenseDate = expenseDate;
		this.price = price;
	}
	
	public Long getExpenseId() {
		return expenseId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getExpenseDate() {
		return expenseDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public static class ExpenseDTOBuilder {
		
		public ExpenseDTO build() {
			return new ExpenseDTO(null, null, null, null, null);
		}
	}
}
