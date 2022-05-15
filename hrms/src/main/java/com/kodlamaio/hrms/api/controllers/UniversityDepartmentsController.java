package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.UniversityDepartment;

@RestController
@RequestMapping("/api/universityDepartments")
public class UniversityDepartmentsController {
	
	private UniversityDepartmentService universityDepartmentService;

	@Autowired
	public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
		this.universityDepartmentService = universityDepartmentService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody UniversityDepartment universityDepartment) {
		return this.universityDepartmentService.add(universityDepartment);
	}

	@GetMapping("/getAll")
	public DataResult<List<UniversityDepartment>> getAll() {
		return this.universityDepartmentService.getAll();
	}

}
