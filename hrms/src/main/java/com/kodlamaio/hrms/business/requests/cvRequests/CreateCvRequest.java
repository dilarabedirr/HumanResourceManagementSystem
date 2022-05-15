package com.kodlamaio.hrms.business.requests.cvRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvRequest {
	
	@JsonIgnore
	private int cvId;
	
	private String coverLetter;
	
	private int jobSeekerId;

}
