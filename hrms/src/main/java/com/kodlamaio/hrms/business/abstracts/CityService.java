package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.CitySearchListDto;
import com.kodlamaio.hrms.business.requests.cityRequests.CreateCityRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface CityService {
	
	DataResult<List<CitySearchListDto>> getAll();
	
	Result add(CreateCityRequest createCityRequest);

}
