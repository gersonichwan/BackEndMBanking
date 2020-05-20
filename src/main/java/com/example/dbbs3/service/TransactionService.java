package com.example.dbbs3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbbs3.entity.Client;
import com.example.dbbs3.entity.HistoryClient;
import com.example.dbbs3.entity.Transaction;
import com.example.dbbs3.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private HistoryClientService historyClientService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction saveNewTransaction(int accNumberSender, int accNumberReceiver, int amount, String type, String note) {
		Client clientSender = clientService.getClientByAccNumber(accNumberSender);
		Client clientReceiver = clientService.getClientByAccNumber(accNumberReceiver);
		
		clientService.updateBalance(clientSender, amount, "send");
		clientService.updateBalance(clientReceiver, amount, "receive");
		
		Transaction newTransaction = new Transaction();
		newTransaction.setClientSender(clientSender);
		newTransaction.setClientReceiver(clientReceiver);
		newTransaction.setAmount(amount);
		newTransaction.setType(type);
		transactionRepository.save(newTransaction);
		
		String titleSender = clientReceiver.getFullName() + " - " + clientReceiver.getAccNumber(); 
		String titleReceiver = clientSender.getFullName() + " - " + clientSender.getAccNumber();
		
		HistoryClient historySender = new HistoryClient();
		historySender.setClient(clientSender);
		historySender.setTransaction(newTransaction);
		historySender.setAmount(amount * -1);
		historySender.setTitle(titleSender);
		historySender.setNote(note);
		historyClientService.saveHistory(historySender);

		HistoryClient historyReceiver = new HistoryClient();
		historyReceiver.setClient(clientReceiver);
		historyReceiver.setTransaction(newTransaction);
		historyReceiver.setAmount(amount);
		historyReceiver.setTitle(titleReceiver);
		historyReceiver.setNote(note);
		historyClientService.saveHistory(historyReceiver);
		
		return newTransaction;
	}
}
