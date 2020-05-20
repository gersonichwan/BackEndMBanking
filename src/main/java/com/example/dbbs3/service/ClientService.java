package com.example.dbbs3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbbs3.entity.Client;
import com.example.dbbs3.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client saveNewClient(Client client) {
		return repository.save(client);
	}
	
	public List<Client> saveNewClients(List<Client> clients) {
		return repository.saveAll(clients);
	}
	
	public List<Client> getAllClients() {
		return repository.findAll();
	}
	
	public Client getClientByAccNumber(int accNumber) {
		return repository.findById(accNumber).orElse(null);
	}
	
	public int getBalanceByAccNumber(int accNumber) {
		Client client = repository.findById(accNumber).orElse(null);
		return client.getBalance();
	}
	
	public String deleteClient(int accNumber) {
		repository.deleteById(accNumber);
		return "client removed || " + accNumber;
	}
	
	public Client updateClient(Client client) {
		Client existingClient = repository.findById(client.getAccNumber()).orElse(null);
		existingClient.setFullName(client.getFullName());
		existingClient.setEmail(client.getEmail());
		existingClient.setMobilePhone(client.getMobilePhone());
		existingClient.setIdCard(client.getIdCard());
		existingClient.setPin(client.getPin());
		existingClient.setBalance(client.getBalance());
		return repository.save(existingClient);
	}
	
	public void updateBalance(Client client, int amount, String type) {
		Client existingClient = repository.findById(client.getAccNumber()).orElse(null);
		int balance = existingClient.getBalance();
		if(type.equalsIgnoreCase("send")) {
			balance = balance - amount;
		} else {
			balance = balance + amount;
		}
		existingClient.setBalance(balance);
		repository.save(existingClient);
	}
	
	public String validateLogin(String accNumber, String pin) {
		int accNum = Integer.parseInt(accNumber);
		List<Client> clients = new ArrayList<>();
		clients = repository.findAll();
		int i = 0;
		do {
			if (accNum == clients.get(i).getAccNumber()) {
				if(pin.equals(clients.get(i).getPin())) {
					return clients.get(i).getFullName();
				} else {
					return null;
				}
			}
			i++;
		} while (i < clients.size());
		return null;
	}
}
