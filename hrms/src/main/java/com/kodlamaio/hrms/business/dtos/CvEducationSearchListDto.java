package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvEducationSearchListDto {
	
	private int cvEducationId;
	
	private int yearOfGraduation;
	
	private int yearOfStarting;
	
	private int cvId;
	
	private int universityId;
	
	private int universityDepartmentId;	
	
}
