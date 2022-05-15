package com.kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailDto {
	
	private String companyName;
	private String positionName;
	private int positionAmount;
	private LocalDate date;
	private boolean status;

}
