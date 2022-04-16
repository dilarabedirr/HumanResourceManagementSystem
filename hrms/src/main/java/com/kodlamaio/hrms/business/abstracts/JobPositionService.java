package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.JobPositionSearchListDto;
import com.kodlamaio.hrms.business.requests.jobPositionRequests.CreateJobPositionRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface JobPositionService {

	DataResult<List<JobPositionSearchListDto>> getAll();

	Result add(CreateJobPositionRequest createJobPositionRequest);

}
