package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemAdminSearchListDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
