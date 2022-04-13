package com.kodlamaio.hrms.business.requests.taskmasterRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskmasterRequest {

	private String email;
	private String password;
	private String companyName;
	private String webSiteName;
	private String phoneNumber;

}
