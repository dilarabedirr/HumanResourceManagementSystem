package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvExperienceService;
import com.kodlamaio.hrms.business.dtos.CvExperienceSearchListDto;
import com.kodlamaio.hrms.business.requests.cvExperienceRequests.CreateCvExperienceRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cvExperiences")
public class CvExperiencesController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperiencesController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}

	@GetMapping(value = "/getAll")
	public DataResult<List<CvExperienceSearchListDto>> getAll() {
		return this.cvExperienceService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCvExperienceRequest createCvExperienceRequest) {
		return this.cvExperienceService.add(createCvExperienceRequest);
	}
	
	@GetMapping("/findByOrderByYearOfEndingDesc")
	public DataResult<List<CvExperienceSearchListDto>> findByOrderByYearOfEndingDesc(){
		return this.cvExperienceService.findByOrderByYearOfEndingDesc();
	}

}
