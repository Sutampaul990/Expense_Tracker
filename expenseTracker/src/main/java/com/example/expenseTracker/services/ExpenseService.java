package com.example.expenseTracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expenseTracker.dto.ExpenseDTO;
import com.example.expenseTracker.models.Expense;

@Service
public interface ExpenseService{
	
	Expense postExpense(ExpenseDTO expenseDTO);
	List<Expense> getAllExpense();
	Expense getExpenseById(Long id);
	Expense updateExpense(Long id, ExpenseDTO expenseDTO);
	void deleteExpense(Long id);
}
