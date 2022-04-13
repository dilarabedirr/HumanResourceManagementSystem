package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.TaskmasterService;
import com.kodlamaio.hrms.business.dtos.TaskmasterSearchListDto;
import com.kodlamaio.hrms.business.requests.taskmasterRequests.CreateTaskmasterRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/taskmasters")
public class TaskmastersController {
	
	private TaskmasterService taskmasterService;

	@Autowired
	public TaskmastersController(TaskmasterService taskmasterService) {
		super();
		this.taskmasterService = taskmasterService;
	}

	@GetMapping("/getall")
	public DataResult<List<TaskmasterSearchListDto>> getAll() {
		return this.taskmasterService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateTaskmasterRequest createTaskmasterRequest) {
		return this.taskmasterService.add(createTaskmasterRequest);
	}
}
