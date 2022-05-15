package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CvService;
import com.kodlamaio.hrms.business.dtos.CvDetailDto;
import com.kodlamaio.hrms.business.dtos.CvSearchListDto;
import com.kodlamaio.hrms.business.requests.cvRequests.CreateCvRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping(value = "/api/cvs")
@CrossOrigin
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CvSearchListDto>> getAll() {
		return this.cvService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Cv> getById(@RequestParam int id) {
		return this.cvService.getById(id);
	}
	
	@GetMapping("{id}/detail-table")
	public DataResult<List<CvDetailDto>> getDetailDtoById(@PathVariable(name = "id", required = true) int id){
		return this.cvService.getDetailDtoById(id);
	}

	@PostMapping("/addCv")
	public Result add(@RequestBody CreateCvRequest createCvRequest) {
		return this.cvService.add(createCvRequest);
	}
}
