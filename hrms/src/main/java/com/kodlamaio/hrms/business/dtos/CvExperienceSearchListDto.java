package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceSearchListDto {

	private int cvExperienceId;
	private String companyName;
	private int yearOfStarting;
	private int yearOfEnding;
	private int cvId;
	private int jobPositionId;

}
