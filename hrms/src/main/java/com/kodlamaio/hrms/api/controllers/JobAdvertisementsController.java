package com.kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.business.dtos.JobAdvertisementSearchListDto;
import com.kodlamaio.hrms.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementSearchListDto>> getAll() {
		return this.jobAdvertisementService.getAll();
	}


	@PostMapping("/add")
	public Result add(@RequestBody CreateJobAdvertisementRequest createJobAdvertisementRequest) {
		return this.jobAdvertisementService.add(createJobAdvertisementRequest);
	}

	@GetMapping("/getByActiveJobAdvertisement")
	public DataResult<List<JobAdvertisementDetailDto>> getByStatus() {
		return this.jobAdvertisementService.getByStatus();
	}

	@GetMapping("/getByStatusTrueOrderByDate")
	public DataResult<List<JobAdvertisementDetailDto>> getByStatusTrueOrderByDate() {
		return this.jobAdvertisementService.getByStatusTrueOrderByDate();
	}

	@GetMapping("/city")
	public DataResult<List<JobAdvertisementDetailDto>> getByCity_cityName(@RequestParam String cityName){
		return this.jobAdvertisementService.getByCity_cityNameAndStatusTrue(cityName);
	}
	@GetMapping("/company")
	public DataResult<List<JobAdvertisementDetailDto>> getByTaskmaster_companyNameAndStatusTrue(@RequestParam String companyName){
		return this.jobAdvertisementService.getByTaskmaster_companyNameAndStatusTrue(companyName);
	}
	
	@GetMapping("/getByDateAndStatusTrue")
	public DataResult<List<JobAdvertisementDetailDto>> getByDateAndStatusTrue(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
		return this.jobAdvertisementService.getByDateAndStatusTrue(localDate);
	}
	@PostMapping("/deactive")
	public Result updateJobAdvertisementStatus(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.updateJobAdvertisementStatus(jobAdvertisementId);
	}

}
