package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.UniversityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.University;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	
	private UniversityService universityService;

	@Autowired
	public UniversitiesController(UniversityService universityService) {
		this.universityService = universityService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody University university) {
		return this.universityService.add(university);
	}

	@GetMapping("/getAll")
	public DataResult<List<University>> getAll() {
		return this.universityService.getAll();
	}

}
