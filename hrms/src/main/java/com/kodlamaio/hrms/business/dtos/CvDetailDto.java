package com.kodlamaio.hrms.business.dtos;

import java.util.List;

import com.kodlamaio.hrms.entities.concretes.CvLanguage;
import com.kodlamaio.hrms.entities.concretes.CvPhoto;
import com.kodlamaio.hrms.entities.concretes.CvSocialMedia;
import com.kodlamaio.hrms.entities.concretes.CvTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetailDto {
	
	private List<CvEducationSearchListDto> cvEducations;
	
	private List<CvExperienceSearchListDto> cvExperiences;
	
	private List<CvLanguage> cvLanguages;
	
	private List<CvSocialMedia> cvSocialMedias;
	
	private List<CvTechnology> cvTechnologies;
	
	private List<CvPhoto> cvPhotos;

}
