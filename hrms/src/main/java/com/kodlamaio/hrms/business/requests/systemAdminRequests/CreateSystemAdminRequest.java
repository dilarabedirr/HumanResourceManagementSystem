package com.kodlamaio.hrms.business.requests.systemAdminRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSystemAdminRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
