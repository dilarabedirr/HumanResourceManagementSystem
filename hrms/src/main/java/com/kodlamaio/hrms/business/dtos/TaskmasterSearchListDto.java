package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskmasterSearchListDto {
	
	private int userId;
	private String email;
	private String companyName;
	private String webSiteName;
	private String phoneNumber;

}
