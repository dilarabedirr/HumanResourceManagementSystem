package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cvEducations", "cvExperiences", "cvLanguages", "cvPhotos", "cvSocialMedias"})
public class Cv {

	@Id
	@Column(name = "cv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;

	@Column(name = "cover_letter")
	private String coverLetter;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "cv")
	private List<CvEducation> cvEducations;
	
	
	@OneToMany(mappedBy = "cv")
	private List<CvExperience> cvExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguages;

	@OneToMany(mappedBy = "cv")
	private List<CvPhoto> cvPhotos;
	
	@OneToMany(mappedBy = "cv")
	private List<CvSocialMedia> cvSocialMedias;
}
