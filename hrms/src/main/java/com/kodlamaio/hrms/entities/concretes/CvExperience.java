package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_experiences")
public class CvExperience {
	
	@Id
	@Column(name="cv_experience_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvExperienceId;
	
	@Column(name="year_of_starting")
	private int yearOfStarting;
	
	@Column(name="year_of_ending")
	private int yearOfEnding;
	
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;

}
