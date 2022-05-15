package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "taskmasters")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Taskmaster extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site_name")
	private String webSiteName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "taskmaster")
	private List<JobAdvertisement> jobAdvertisements;

}
