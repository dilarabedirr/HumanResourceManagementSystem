package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvTechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvTechnology;


@RestController
@RequestMapping("/api/cvTechnology")
public class CvTechnologiesController {
	
	private CvTechnologyService cvTechnologyService;

	@Autowired
	public CvTechnologiesController(CvTechnologyService cvTechnologyService) {
		super();
		this.cvTechnologyService = cvTechnologyService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CvTechnology>> getAll() {
		return this.cvTechnologyService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.add(cvTechnology);
	}
}
