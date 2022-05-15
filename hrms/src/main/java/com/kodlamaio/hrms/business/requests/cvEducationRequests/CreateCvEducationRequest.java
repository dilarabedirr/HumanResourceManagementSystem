package com.kodlamaio.hrms.business.requests.cvEducationRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvEducationRequest {
	
	@JsonIgnore
	private int cvEducationId;
	
	private int yearOfStarting;
	
	private int yearOfGraduation;
	
	private int universityId;
	
	private int universityDepartmentId;
	
	private int cvId;
}
