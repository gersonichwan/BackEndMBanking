package com.example.dbbs3.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.entity.Client;
import com.example.dbbs3.entity.Transaction;
import com.example.dbbs3.model.OtpReponse;
import com.example.dbbs3.model.OtpRequest;
import com.example.dbbs3.model.TempOtp;
import com.example.dbbs3.service.ClientService;
import com.example.dbbs3.service.TempOtpService;
import com.example.dbbs3.service.TransactionService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	TempOtpService tempOtpService;
	
	@Autowired
	ClientService clientService;
	
	@RequestMapping(value = "/saveNewTransaction", method = RequestMethod.POST)
	@ResponseBody
	public Transaction saveNewTransaction(@RequestBody ObjectNode newTransaction) {
		int accNumberSender = newTransaction.get("accNumberSender").asInt();
		int accNumberReceiver = newTransaction.get("accNumberReceiver").asInt();
		int amount = newTransaction.get("amount").asInt();
		String type = newTransaction.get("type").asText();
		String note = newTransaction.get("note").asText();
		return transactionService.saveNewTransaction(accNumberSender, accNumberReceiver, amount, type, note);
	}
	
	@RequestMapping(value = "/otp", method = RequestMethod.POST)
	ResponseEntity<OtpReponse> cekToken(@RequestBody OtpRequest accNumber) {
		OtpReponse response = new OtpReponse();
		
		Date now = new Date();
		Calendar expired = Calendar.getInstance();
		expired.add(Calendar.MINUTE, 2);
		Date twoMinutesFromNow = expired.getTime();
		    
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		
		String code = Integer.toString(n);
		Client data = clientService.getClientByAccNumber(accNumber.getAccNumber());
		
		if(data != null) {
			try {
				TempOtp tempOtp = new TempOtp();
				tempOtp.setAccNumber(data.getAccNumber());
				tempOtp.setCreatedDate(now);
				tempOtp.setExpDate(twoMinutesFromNow);
				tempOtp.setToken(code);
			  
				tempOtpService.saveTempOtp(tempOtp);
				response.setChekAccNumber(true);
				response.setToken(code);
			} catch (Exception e) {
				System.err.println("error : " + e.getCause());
			}
		}else {
			response.setChekAccNumber(false);
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
