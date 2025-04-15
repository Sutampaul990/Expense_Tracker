package com.example.expenseTracker.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.expenseTracker.models.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	List<Expense> findByDateBetween(LocalDate startDate,LocalDate endDate);
	
	@Query("SELECT SUM(e.amount) FROM Expense e")
	Double sumAllAmounts();
	
	Optional<Expense> findFirstByOrderByDateDesc();
}
