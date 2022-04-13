package com.kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapters.abstracts.VerificationService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailVerificationManager implements VerificationService{

	@Override
	public Result checkIfUserVerification() {
		System.out.println("mail doğrulandı");
		return new SuccessResult();
	}
	
	

}
