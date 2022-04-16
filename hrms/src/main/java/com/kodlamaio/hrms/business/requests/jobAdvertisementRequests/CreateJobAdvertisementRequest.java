package com.kodlamaio.hrms.business.requests.jobAdvertisementRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobAdvertisementRequest {

	private String detail;
	
	private int positionAmount;
	
	private boolean status;
	
	private LocalDate date;

	private double minSalary;

	private double maxSalary;
	
	private int cityId;
	
	private int taskmasterId;
	
	private int positionId;
	

}
