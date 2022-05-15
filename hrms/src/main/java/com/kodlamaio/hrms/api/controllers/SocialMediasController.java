package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.SocialMediaService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedia")
public class SocialMediasController {
	
	private SocialMediaService socialMediaService;
	
	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}

	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll(){
		return this.socialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody  SocialMedia socialMedia){
		return this.socialMediaService.add(socialMedia);
	}

}
