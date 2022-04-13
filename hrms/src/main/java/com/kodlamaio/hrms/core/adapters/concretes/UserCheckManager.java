package com.kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserCheckManager implements UserCheckService{

	@Override
	public Result checkIfRealCustomer(CreateJobSeekerRequest createJobSeekerRequest) {
		return new SuccessResult();
	}

}
