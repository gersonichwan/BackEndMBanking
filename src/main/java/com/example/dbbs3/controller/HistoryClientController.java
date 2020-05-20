package com.example.dbbs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.entity.HistoryClient;
import com.example.dbbs3.service.HistoryClientService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class HistoryClientController {

	@Autowired
	private HistoryClientService service;
	
	@RequestMapping(value = "/getAllHistoriesByAccNumber", method = RequestMethod.POST)
	@ResponseBody
	public List<HistoryClient> getAllHistoriesByAccNumber(@RequestBody ObjectNode object) {
		return service.getAllHistoriesByAccNumber(object.get("accNumber").asInt());
	}
	
	@RequestMapping(value = "/getAllHistoriesByAccNumberAndDates", method = RequestMethod.POST)
	@ResponseBody
	public List<HistoryClient> getAllHistoriesByAccNumberAndDates(@RequestBody ObjectNode object) {
		int accNumber = object.get("accNumber").asInt();
		String startDate = object.get("startDate").asText();
		String endDate = object.get("endDate").asText();
		return service.getAllHistoriesByAccNumberAndDates(accNumber, startDate, endDate);
	}
	
}
