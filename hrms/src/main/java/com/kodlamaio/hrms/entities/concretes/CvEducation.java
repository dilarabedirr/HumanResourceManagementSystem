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
@Table(name="cv_educations")
public class CvEducation {
	
	@Id
	@Column(name="cv_education_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvEducationId;
	
	@Column(name="year_of_starting")
	private int yearOfStarting;
	
	@Column(name="year_of_graduation")
	private int yearOfGraduation;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;
	
	
	@ManyToOne
	@JoinColumn(name="university_department_id")
	private UniversityDepartment universityDepartment;

}
