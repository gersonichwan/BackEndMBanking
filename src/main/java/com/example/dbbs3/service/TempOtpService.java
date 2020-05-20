package com.example.dbbs3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbbs3.model.TempOtp;
import com.example.dbbs3.repository.TempOtpRepository;

@Service
public class TempOtpService {
	
	@Autowired
	private TempOtpRepository tempOtpRepository;
	
	public List<TempOtp> getTempOtpByAccNumber(int accNumber){
		return tempOtpRepository.findByAccNumber(accNumber);
	}
	
	public TempOtp saveTempOtp(TempOtp tempOtp) {
		return tempOtpRepository.save(tempOtp);
	}

}
