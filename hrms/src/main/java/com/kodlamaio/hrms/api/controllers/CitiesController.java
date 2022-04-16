package com.kodlamaio.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.business.dtos.CitySearchListDto;
import com.kodlamaio.hrms.business.requests.cityRequests.CreateCityRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CitySearchListDto>> getAll() {
		return this.cityService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCityRequest createCityRequest) {
		return this.cityService.add(createCityRequest);
	}

}
