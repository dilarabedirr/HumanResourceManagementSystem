package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.CvExperienceSearchListDto;
import com.kodlamaio.hrms.business.requests.cvExperienceRequests.CreateCvExperienceRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface CvExperienceService {
	
	public DataResult<List<CvExperienceSearchListDto>> getAll();

	public Result add(CreateCvExperienceRequest createCvExperienceRequest);
	
	public DataResult<List<CvExperienceSearchListDto>> findByOrderByYearOfEndingDesc();

}
