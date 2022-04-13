package com.kodlamaio.hrms.core.adapters.abstracts;

import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface UserCheckService {
	Result checkIfRealCustomer(CreateJobSeekerRequest createJobSeekerRequest);
}
