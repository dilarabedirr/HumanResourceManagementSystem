package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSearchListDto {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String yearOfBirth;
	private String nationalNumber;

}
