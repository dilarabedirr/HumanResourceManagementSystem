package com.kodlamaio.hrms.business.requests.cvExperienceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvExperienceRequest {
	
	@JsonIgnore
	private int cvExperienceId;
	
	private String companyName;
	
	private int yearOfEnding;
	
	private int yearOfStarting;
	
	private int cvId;
	
	private int jobPositionId;

}
