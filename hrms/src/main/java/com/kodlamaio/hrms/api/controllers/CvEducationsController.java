package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvEducationService;
import com.kodlamaio.hrms.business.dtos.CvEducationSearchListDto;
import com.kodlamaio.hrms.business.requests.cvEducationRequests.CreateCvEducationRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/cvEducations")
public class CvEducationsController {

	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CvEducationSearchListDto>> getAll() {
		return this.cvEducationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCvEducationRequest createCvEducationRequest) {
		return this.cvEducationService.add(createCvEducationRequest);
	}
	
	@GetMapping("/findByOrderByYearOfGraduationDesc")
	public DataResult<List<CvEducationSearchListDto>> findByOrderByYearOfGraduationDesc(){
		return this.cvEducationService.findByOrderByYearOfGraduationDesc();
	}

}
