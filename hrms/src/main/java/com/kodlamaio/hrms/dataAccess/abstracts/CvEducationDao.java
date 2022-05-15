package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer>{
	
	List<CvEducation> findByOrderByYearOfGraduationDesc();

}
