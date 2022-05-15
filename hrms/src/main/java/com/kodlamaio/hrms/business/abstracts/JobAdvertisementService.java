package com.kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.kodlamaio.hrms.business.dtos.JobAdvertisementSearchListDto;
import com.kodlamaio.hrms.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisementSearchListDto>> getAll();
	
	DataResult<List<JobAdvertisementDetailDto>> getByCity_cityNameAndStatusTrue(String cityName);
	
	DataResult<List<JobAdvertisementDetailDto>> getByTaskmaster_companyNameAndStatusTrue(String companyName);
	
	DataResult<List<JobAdvertisementDetailDto>> getByDateAndStatusTrue(LocalDate date);
	
	DataResult<List<JobAdvertisementDetailDto>> getByStatus();
	
	DataResult<List<JobAdvertisementDetailDto>> getByStatusTrueOrderByDate();
	
	Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest);
	
	Result updateJobAdvertisementStatus(int jobAdvertisementId);
	
}
