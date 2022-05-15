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
@Table(name="cv_languages")
public class CvLanguage {
	
	@Id
	@Column(name="cv_language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvLanguageId;
	
	@Column(name="language_level")
	private int languageLevel;
	
	@ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
	@ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

}
