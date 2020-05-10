package com.moonrider.service;

import java.util.List;

import com.moonrider.dto.ExpenseDTO;

public interface ExpenseTrackingService {

	List<ExpenseDTO> getExpenses();

}