package com.moonrider.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.moonrider.domain.Expense;

public class ExpenseDTO {
	
	private final Long expenseId;
	private final String name;
	private final String description;
	private final LocalDate expenseDate;
	private final BigDecimal price;
	private final String currency;
	
	public ExpenseDTO(Long expenseId, String name, String description, LocalDate expenseDate, BigDecimal price, String currency) {
		super();
		this.expenseId = expenseId;
		this.name = name;
		this.description = description;
		this.expenseDate = expenseDate;
		this.price = price;
		this.currency = currency;
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
	
	public String getCurrency() {
		return currency;
	}
	
	public static class ExpenseDTOBuilder {
		private Long expenseId;
		private String name;
		private String description;
		private LocalDate expenseDate;
		private BigDecimal price;
		private String currency;
		
		public ExpenseDTOBuilder() {}
		
		public ExpenseDTOBuilder(Expense expense) {
			this.expenseId = expense.getExpenseId();
			this.name = expense.getName();
			this.description = expense.getDescription();
			this.expenseDate = expense.getExpenseDate();
			this.price = expense.getPrice();
			this.currency = "EUR";
		}
		
		public ExpenseDTOBuilder expenseId(Long expenseId) {
			this.expenseId = expenseId;
			return this;
		}
		
		public ExpenseDTOBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public ExpenseDTOBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public ExpenseDTOBuilder expenseDate(LocalDate expenseDate) {
			this.expenseDate = expenseDate;
			return this;
		}
		
		public ExpenseDTOBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public ExpenseDTOBuilder currency(String currency) {
			this.currency = currency;
			return this;
		}
		
		public ExpenseDTO build() {
			return new ExpenseDTO(expenseId, name, description, expenseDate, price, currency);
		}
	}
}
