package com.kodlamaio.hrms.business.requests.cvLanguageRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvLanguageRequest {
	
	@JsonIgnore
	private int cvLanguageId;
	private int cvId;
	private int languageId;
	private int languageLevel;

}
