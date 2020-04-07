package com.moonrider.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.moonrider.dao.converter.ExpenseConverter;
import com.moonrider.dao.dto.ExpenseDTO;
import com.moonrider.domain.Expense;

@ApplicationScoped
public class ExpenseDAO {

	@Inject
	private EntityManager em;
	
	private final ExpenseConverter expenseConverter;
	
	@Inject
	ExpenseDAO(ExpenseConverter expenseConverter) {
		this.expenseConverter = expenseConverter;
	}
	
	public List<ExpenseDTO> getExpenses() {
		List<Expense> expenses = em.createQuery("Select e FROM Expense e", Expense.class).getResultList();
		return expenses.stream().map(expenseConverter::convert).collect(Collectors.toList());
	}
}
