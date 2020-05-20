package com.example.dbbs3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dbbs3.entity.AccountRelation;

@Repository
public interface AccountRelationRepository extends JpaRepository<AccountRelation, Integer>{
	
	@Query(value = "SELECT * FROM tbl_account_relation ar WHERE ar.acc_number_main=:acc_number", nativeQuery = true)
	List<AccountRelation> getAllRelationsByAccNumber(int acc_number);
}
