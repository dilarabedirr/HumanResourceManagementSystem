package com.kodlamaio.hrms.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionSearchListDto {
	
	private int positionId;
	private String positionName;

}
