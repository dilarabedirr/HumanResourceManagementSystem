package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.TaskmasterService;
import com.kodlamaio.hrms.business.dtos.TaskmasterSearchListDto;
import com.kodlamaio.hrms.business.requests.taskmasterRequests.CreateTaskmasterRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TaskmasterDao;
import com.kodlamaio.hrms.entities.concretes.Taskmaster;

@Service
public class TaskmasterManager implements TaskmasterService {

	private TaskmasterDao taskmasterDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public TaskmasterManager(TaskmasterDao taskmasterDao, ModelMapperService modelMapperService) {
		super();
		this.taskmasterDao = taskmasterDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<TaskmasterSearchListDto>> getAll() {
		List<Taskmaster> result = this.taskmasterDao.findAll();
		List<TaskmasterSearchListDto> response = result.stream()
				.map(taskmaster -> modelMapperService.forDto().map(taskmaster, TaskmasterSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<TaskmasterSearchListDto>>(response);
	}

	@Override
	public Result add(CreateTaskmasterRequest createTaskmasterRequest) {
		Taskmaster taskmaster = modelMapperService.forRequest().map(createTaskmasterRequest, Taskmaster.class);
		this.taskmasterDao.save(taskmaster);
		return new SuccessResult("İş veren eklendi.");
	}

}
