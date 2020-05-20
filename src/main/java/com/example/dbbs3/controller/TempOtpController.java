package com.example.dbbs3.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbbs3.model.OtpRequest;
import com.example.dbbs3.model.TempOtp;
import com.example.dbbs3.service.TempOtpService;

@RestController
public class TempOtpController {
	public static boolean compareDates(Date date1,Date date2){
        if(date1.after(date2)){
            return false;
        }else if(date1.before(date2)){
           	return true;
        }else if(date1.equals(date2)){
            return true;
        }
        return true;
    }
	
	@Autowired
	TempOtpService tempOtpService;
	
	@RequestMapping(value = "/checkOtp", method = RequestMethod.POST)
	public boolean checkToken(@RequestBody OtpRequest request) {
		List<TempOtp> list = tempOtpService.getTempOtpByAccNumber(request.getAccNumber());
		TempOtp data = list.get(list.size()-1);
		Date now = new Date();
		
		if(data.getToken().equals(request.getToken())) {
			if(compareDates(now, data.getExpDate())) {
				return true;
			}
		}else {
			return false;
		}	
		
		return false;
	}
}
