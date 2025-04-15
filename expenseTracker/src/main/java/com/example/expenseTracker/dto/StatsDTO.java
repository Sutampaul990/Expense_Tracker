package com.example.expenseTracker.dto;

import com.example.expenseTracker.models.Expense;
import com.example.expenseTracker.models.Income;

import lombok.Data;

@Data

public class StatsDTO {

	private Double income;
	private Double expense;
	private Income latestIncome;
	private Expense latestExpense;
	
	private Double balance;
	
	private Double minIncome;
	private Double maxIncome;
	
	private Double minExpense;
	private Double maxExpense;
	
}
