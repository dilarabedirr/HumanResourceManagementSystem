package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvLanguageService;
import com.kodlamaio.hrms.business.requests.cvLanguageRequests.CreateCvLanguageRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvLanguage;

@RestController
@RequestMapping("/api/cvLanguages")
public class CvLanguagesController {
	
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvLanguage>> getAll(){
		return this.cvLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCvLanguageRequest createCvLanguageRequest){
		return this.cvLanguageService.add(createCvLanguageRequest);
	}

}
