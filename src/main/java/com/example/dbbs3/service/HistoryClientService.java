package com.example.dbbs3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbbs3.entity.HistoryClient;
import com.example.dbbs3.repository.HistoryClientRepository;

@Service
public class HistoryClientService {
	
	@Autowired
	private HistoryClientRepository repository;
	
	public HistoryClient saveHistory(HistoryClient history) {
		return repository.save(history);
	}
	
	public List<HistoryClient> getAllHistoriesByAccNumber(int acc_number) {
		return repository.getAllHistoriesbyAccNumber(acc_number);
	}
	
	public List<HistoryClient> getAllHistoriesByAccNumberAndDates(int accNumber, String startDate, String endDate){
		return repository.getAllHistoriesByAccNumberAndDates(accNumber, startDate, endDate);
	}
	
}
