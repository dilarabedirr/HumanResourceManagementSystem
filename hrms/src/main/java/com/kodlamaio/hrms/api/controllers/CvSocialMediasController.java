package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvSocialMedia;

@RestController
@RequestMapping("/api/cvSocialMedia")
public class CvSocialMediasController {
	
	private CvSocialMediaService cvSocialMediaService;

	@Autowired
	public CvSocialMediasController(CvSocialMediaService cvSocialMediaService) {
		super();
		this.cvSocialMediaService = cvSocialMediaService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CvSocialMedia>> getAll(){
		return this.cvSocialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSocialMedia cvSocialMedia) {
		return this.cvSocialMediaService.add(cvSocialMedia);
	}
}
