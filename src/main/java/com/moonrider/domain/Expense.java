package com.moonrider.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expense_id")
	private Long expenseId;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price", nullable = false)
	private BigDecimal price;

	@Column(name="expense_date")
	private LocalDate expenseDate;
	
	public Expense() { }
	
	
	public Expense(String name, String description, BigDecimal price, LocalDate expenseDate) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.expenseDate = expenseDate;
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

	public BigDecimal getPrice() {
		return price;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public static class ExpenseBuilder {
		private String name;
		private String description;
		private BigDecimal price;
		private LocalDate expenseDate;
		
		public ExpenseBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public ExpenseBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public ExpenseBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public ExpenseBuilder expenseDate(LocalDate expenseDate) {
			this.expenseDate = expenseDate;
			return this;
		}
		
		public Expense build() {
			return new Expense(name, description, price,  expenseDate);
		}
	}
}
