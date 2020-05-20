package com.example.dbbs3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbbs3.model.TempOtp;

@Repository
public interface TempOtpRepository extends JpaRepository<TempOtp, Long>{
	List<TempOtp> findByAccNumber(int accNumber);
}
