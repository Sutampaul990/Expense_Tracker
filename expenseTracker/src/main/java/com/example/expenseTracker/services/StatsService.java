package com.example.expenseTracker.services;

import org.springframework.stereotype.Service;

import com.example.expenseTracker.dto.GraphDTO;
import com.example.expenseTracker.dto.StatsDTO;

@Service
public interface StatsService {

	GraphDTO getChartData();
	StatsDTO getStats();
	
}
