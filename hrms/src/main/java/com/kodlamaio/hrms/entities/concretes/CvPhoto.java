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
@Table(name = "cv_photos")
@AllArgsConstructor
@NoArgsConstructor
public class CvPhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_photo_id")
	private int cvPhotoId;
	
	@Column(name = "photo_path")
	private String photoPath;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	

}
