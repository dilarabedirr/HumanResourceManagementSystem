package com.kodlamaio.hrms.business.requests.jobseekerRequests;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobSeekerRequest {
	

	private String firstName;

	private String lastName;

	private String email;

	private String password;
	
	private String passwordAgain;

	private String yearOfBirth;
	
	private String nationalNumber;

}
