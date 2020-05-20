package com.example.dbbs3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbbs3.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}
