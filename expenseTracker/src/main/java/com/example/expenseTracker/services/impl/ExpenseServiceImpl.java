package com.example.expenseTracker.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenseTracker.dto.ExpenseDTO;
import com.example.expenseTracker.models.Expense;
import com.example.expenseTracker.repository.ExpenseRepository;
import com.example.expenseTracker.services.ExpenseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private final ExpenseRepository expenseRepository;
	
	public Expense postExpense(ExpenseDTO expenseDTO) {
		return saveOrUpdateExpense(new Expense(), expenseDTO);
	}
	
	private Expense saveOrUpdateExpense(Expense expense,ExpenseDTO expenseDTO) {
		expense.setTitle(expenseDTO.getTitle());
		expense.setDate(expenseDTO.getDate());
		expense.setAmount(expenseDTO.getAmount());
		expense.setDescription(expenseDTO.getDescription());
		expense.setCategory(expenseDTO.getCategory());
		
		return expenseRepository.save(expense);
	}
	
	public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
		} else {
			throw new EntityNotFoundException("Expense isn't present with id "+id);
		}
	}
	
	public List<Expense> getAllExpense(){
		return expenseRepository.findAll().stream()
				.sorted(Comparator.comparing(Expense::getDate).reversed())
				.collect(Collectors.toList());
	}
	
	public Expense getExpenseById(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			throw new EntityNotFoundException("Expense isn't present with id "+id);
		}
	}
	
	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Expense isn't present with id "+id);
		}
	}
	
}
