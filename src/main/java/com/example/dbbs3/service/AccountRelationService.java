package com.example.dbbs3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbbs3.dto.DTOAccountRelation;
import com.example.dbbs3.entity.AccountRelation;
import com.example.dbbs3.repository.AccountRelationRepository;

@Service
public class AccountRelationService {

	@Autowired
	AccountRelationRepository repository;
	
	public AccountRelation saveNewRelation(AccountRelation relation) {
		return repository.save(relation);
	}
	
	public List<DTOAccountRelation> getAllRelationsByAccNumber(int accNumber){
		List<AccountRelation> relations = repository.getAllRelationsByAccNumber(accNumber);
		List<DTOAccountRelation> dtoRelations = new ArrayList<DTOAccountRelation>();
		for (int i = 0; i < relations.size(); i++) {
			int accNumberDest = relations.get(i).getClientDest().getAccNumber();
			String fullNameDest = relations.get(i).getClientDest().getFullName(); 
			DTOAccountRelation newDTO = new DTOAccountRelation(accNumberDest, fullNameDest);
			dtoRelations.add(newDTO);
		}
		return dtoRelations;
	}
}
