package com.example.dbbs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.entity.Client;
import com.example.dbbs3.service.ClientService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@PostMapping("/saveNewClient")
	public Client Client(@RequestBody Client client) {
		return service.saveNewClient(client);
	}
	
	@PostMapping("/saveNewClients")
	public List<Client> saveNewClients(@RequestBody List<Client> clients) {
		return service.saveNewClients(clients);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return service.getAllClients();
	}
	
	@GetMapping("/client/{accNumber}")
	public Client getClientByAccNumber(@PathVariable int accNumber) {
		return service.getClientByAccNumber(accNumber);
	}
	
	@RequestMapping(value = "/getBalanceByAccNumber", method = RequestMethod.POST)
	@ResponseBody
	public int getBalanceByAccNumber(@RequestBody ObjectNode object) {
		return service.getBalanceByAccNumber(object.get("accNumber").asInt());
	}
	
	@PutMapping("/updateClient")
	public Client updateClient(@RequestBody Client client) {
		return service.updateClient(client);
	}
	
	@DeleteMapping("/delete/{accNumber}")
	public String deleteClient(@PathVariable int accNumber) {
		return service.deleteClient(accNumber);
	}
	
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	@ResponseBody
	public String validateLogin(@RequestBody ObjectNode clientLogin) {
		return service.validateLogin(clientLogin.get("accNumber").asText(), clientLogin.get("pin").asText());
	}
	
	@RequestMapping(value = "/validateDestinationAccount", method = RequestMethod.POST)
	@ResponseBody
	public Client validateDestinationAccount(@RequestBody ObjectNode object) {
		return service.getClientByAccNumber(object.get("accNumber").asInt());
	}
}
