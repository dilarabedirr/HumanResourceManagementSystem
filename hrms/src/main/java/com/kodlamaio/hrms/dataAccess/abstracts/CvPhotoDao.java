package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{

}
