package com.kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapters.abstracts.HrmsVerificationService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class HrmsVerificationManager implements HrmsVerificationService{

	@Override
	public Result checkIfHrmsUserVerification() {
		System.out.println("hrms onay verdi/doğruladı");
		return new SuccessResult();
	}

}
