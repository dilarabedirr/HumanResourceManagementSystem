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

	@GetMapping("/getByCityId")
	public DataResult<List<JobAdvertisementSearchListDto>> getByCity_CityId(@RequestParam int cityId) {
		return this.jobAdvertisementService.getByCity_CityId(cityId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateJobAdvertisementRequest createJobAdvertisementRequest) {
		return this.jobAdvertisementService.add(createJobAdvertisementRequest);
	}

	@GetMapping("/getByActiveJobAdvertisement")
	public DataResult<List<JobAdvertisementSearchListDto>> getByStatus() {
		return this.jobAdvertisementService.getByStatus();
	}

	@GetMapping("/getByStatusTrueOrderByDate")
	public DataResult<List<JobAdvertisementSearchListDto>> getByStatusTrueOrderByDate() {
		return this.jobAdvertisementService.getByStatusTrueOrderByDate();
	}

	@GetMapping("/getByTaskmasterIdAndStatusTrue")
	public DataResult<List<JobAdvertisementSearchListDto>> getByTaskmasterIdAndStatusTrue(@RequestParam int taskmasterId) {
		return this.jobAdvertisementService.getByTaskmasterIdAndStatusTrue(taskmasterId);
	}
	
	@GetMapping("/getByDateAndStatusTrue")
	public DataResult<List<JobAdvertisementSearchListDto>> getByDateAndStatusTrue(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
		return this.jobAdvertisementService.getByDateAndStatusTrue(localDate);
	}

}
