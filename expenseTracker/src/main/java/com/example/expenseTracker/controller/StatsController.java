package com.example.expenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenseTracker.dto.GraphDTO;
import com.example.expenseTracker.services.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

	@Autowired
	StatsService statsService;
	
	@GetMapping("/chart")
	public ResponseEntity<GraphDTO> getChartDetails(){
		return ResponseEntity.ok(statsService.getChartData());
	}
	
	@GetMapping
	public ResponseEntity<?> getStats(){
		return ResponseEntity.ok(statsService.getStats());
	}
	
}
