package com.example.expenseTracker.dto;

import java.util.List;

import com.example.expenseTracker.models.Expense;
import com.example.expenseTracker.models.Income;

import lombok.Data;

@Data

public class GraphDTO {
	private List<Expense> expenseList;
	private List<Income> incomeList;
}
