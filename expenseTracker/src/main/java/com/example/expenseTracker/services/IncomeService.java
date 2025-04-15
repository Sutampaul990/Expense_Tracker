package com.example.expenseTracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expenseTracker.dto.IncomeDTO;
import com.example.expenseTracker.models.Income;

@Service
public interface IncomeService {
	
	Income postIncome(IncomeDTO incomeDTO);
	List<IncomeDTO> getAllIncomes();
	Income updateIncome(Long id,IncomeDTO incomeDTO);
	IncomeDTO getIncomeById(Long id);
	void deleteIncome(Long id);
}
