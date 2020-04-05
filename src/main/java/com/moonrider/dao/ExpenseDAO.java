package com.moonrider.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.moonrider.domain.Expense;
import com.moonrider.dto.ExpenseDTO;
import com.moonrider.dto.ExpenseFactory;

@ApplicationScoped
public class ExpenseDAO {

	private final EntityManager em;
	
	@Inject
	ExpenseDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<ExpenseDTO> listExpenses() {
		ExpenseFactory expenseFactory = new ExpenseFactory();
		
		List<Expense> expenses = em.createQuery("Select e FROM Expense e", Expense.class).getResultList();
		return expenses.stream().map(expenseFactory::createExpenseDTO).collect(Collectors.toList());
	}
}
