package com.kodlamaio.hrms.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementSearchListDto {
	
	private int jobAdvertisementId;

	private String detail;
	
	private int positionAmount;
	
	private boolean status;
	
	private LocalDate date;

	private double minSalary;

	private double maxSalary;
	
	private int cityId;
	
	private int companyId;
	
	private int positionId;

}
