package com.moonrider.service;

import java.util.List;

import com.moonrider.dao.dto.ExpenseDTO;

public interface ExpenseTrackingService {

	List<ExpenseDTO> getExpenses();

}