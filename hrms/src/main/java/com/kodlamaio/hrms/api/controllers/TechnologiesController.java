package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.TechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {
	
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Technology>> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Technology technology) {
		return this.technologyService.add(technology);
	}

}
