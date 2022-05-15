package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.business.abstracts.CvPhotoService;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cvPhotos")
public class CvPhotosController {
	
	private CvPhotoService cvPhotoService;

	@Autowired
	public CvPhotosController(CvPhotoService cvPhotoService) {
		super();
		this.cvPhotoService = cvPhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestPart("file") MultipartFile cvImage,  @RequestParam("cvId") int cvId) {
		return this.cvPhotoService.add(cvImage,cvId);
	}

}
