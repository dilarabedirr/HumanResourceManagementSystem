package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.business.abstracts.SystemAdminService;
import com.kodlamaio.hrms.business.dtos.JobSeekerSearchListDto;
import com.kodlamaio.hrms.business.dtos.SystemAdminSearchListDto;
import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.business.requests.systemAdminRequests.CreateSystemAdminRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/systemAdmins")
public class SystemAdminsController {

	private SystemAdminService systemAdminService;

	@Autowired
	public SystemAdminsController(SystemAdminService systemAdminService) {
		super();
		this.systemAdminService = systemAdminService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemAdminSearchListDto>> getAll() {
		return this.systemAdminService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateSystemAdminRequest createSystemAdminRequest) {
		return this.systemAdminService.add(createSystemAdminRequest);
	}

}
