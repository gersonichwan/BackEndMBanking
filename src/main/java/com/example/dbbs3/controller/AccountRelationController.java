package com.example.dbbs3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.dto.DTOAccountRelation;
import com.example.dbbs3.entity.AccountRelation;
import com.example.dbbs3.service.AccountRelationService;
import com.example.dbbs3.service.ClientService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class AccountRelationController {

	@Autowired
	private AccountRelationService relationService;
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/getAllRelationsByAccNumber", method = RequestMethod.POST)
	@ResponseBody
	public List<DTOAccountRelation> getAllRelationsByAccNumber(@RequestBody ObjectNode object) {
		return relationService.getAllRelationsByAccNumber(object.get("accNumber").asInt());
	}
	
	@RequestMapping(value = "/saveNewRelation", method = RequestMethod.POST)
	@ResponseBody
	public AccountRelation saveNewRelation(@RequestBody ObjectNode object) {
		
		int accNumberMain = object.get("accNumberMain").asInt();
		int accNumberDest = object.get("accNumberDest").asInt();
		
		AccountRelation relation = new AccountRelation();
		
		relation.setClientMain(clientService.getClientByAccNumber(accNumberMain));
		relation.setClientDest(clientService.getClientByAccNumber(accNumberDest));
		
		return relationService.saveNewRelation(relation);
	}
}
