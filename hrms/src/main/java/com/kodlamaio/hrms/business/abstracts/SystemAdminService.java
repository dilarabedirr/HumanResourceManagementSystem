package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.SystemAdminSearchListDto;
import com.kodlamaio.hrms.business.requests.systemAdminRequests.CreateSystemAdminRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface SystemAdminService {
	
DataResult<List<SystemAdminSearchListDto>> getAll();
	
	Result add(CreateSystemAdminRequest createSystemAdminRequest);
}
