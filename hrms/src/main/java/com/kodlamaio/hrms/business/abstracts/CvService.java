package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.CvDetailDto;
import com.kodlamaio.hrms.business.dtos.CvSearchListDto;
import com.kodlamaio.hrms.business.requests.cvRequests.CreateCvRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	
	public DataResult<List<CvSearchListDto>> getAll();

	public Result add(CreateCvRequest createCvRequest);
	
	public DataResult<Cv> getById(int id);
	
	public DataResult<List<CvDetailDto>> getDetailDtoById(int id);

}
