package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.dtos.TaskmasterSearchListDto;
import com.kodlamaio.hrms.business.requests.taskmasterRequests.CreateTaskmasterRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface TaskmasterService {
	
	DataResult<List<TaskmasterSearchListDto>> getAll();
	
	Result add(CreateTaskmasterRequest createTaskmasterRequest);

}
