package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.JobSeekerSearchListDto;
import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface JobSeekerService {
	
	DataResult<List<JobSeekerSearchListDto>> getAll();
	
	Result add(CreateJobSeekerRequest createJobSeekerRequest);

}
