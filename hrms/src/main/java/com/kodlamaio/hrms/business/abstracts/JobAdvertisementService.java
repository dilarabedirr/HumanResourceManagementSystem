package com.kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.kodlamaio.hrms.business.dtos.JobAdvertisementSearchListDto;
import com.kodlamaio.hrms.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisementSearchListDto>> getAll();

	DataResult<List<JobAdvertisementSearchListDto>> getByCity_CityId(int cityId);
	
	DataResult<List<JobAdvertisementSearchListDto>> getByStatus();
	
	DataResult<List<JobAdvertisementSearchListDto>> getByStatusTrueOrderByDate();
	
	DataResult<List<JobAdvertisementSearchListDto>> getByTaskmasterIdAndStatusTrue(int taskmasterId);
	
	DataResult<List<JobAdvertisementSearchListDto>> getByDateAndStatusTrue(LocalDate date);
	
	Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest);
	
}
