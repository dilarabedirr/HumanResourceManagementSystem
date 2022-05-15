package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.CvEducationSearchListDto;
import com.kodlamaio.hrms.business.requests.cvEducationRequests.CreateCvEducationRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface CvEducationService {
	
	public DataResult<List<CvEducationSearchListDto>> getAll();

	public Result add(CreateCvEducationRequest createCvEducationRequest);
	
	public DataResult<List<CvEducationSearchListDto>> findByOrderByYearOfGraduationDesc();
}
