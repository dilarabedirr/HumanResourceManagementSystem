package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSearchListDto {
	
	private int cvId;
	
	private String coverLetter;
	
	private int jobSeekerId;

}
