package com.kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByStatusTrue();
	
	List<JobAdvertisement> getByStatusTrueOrderByDate();
	
	List<JobAdvertisement> getByCity_cityNameAndStatusTrue(String cityName);
	
	List<JobAdvertisement> getByTaskmaster_companyNameAndStatusTrue(String companyName);
	
	List<JobAdvertisement> getByDateAndStatusTrue(LocalDate date);
	
	@Modifying
	@Query("update JobAdvertisement set status=false where jobAdvertisementId=:jobAdvertisementId")
	int updateJobAdvertisementStatus(int jobAdvertisementId);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Query("Select new com.kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto(t.companyName, ja.positionAmount, ja.date)"
//			+ " From Taskmaster t Inner Join t.jobAdvertisements ja where ja.status = true")

//	@Query("Select new com.kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto(t.companyName, jp.positionName, ja.positionAmount, ja.date)"
//			+ " From JobAdvertisement ja Inner Join ja.jobPosition jp Inner Join ja.taskmaster t where ja.status = true")
//	List<JobAdvertisementDetailDto> getJobAdvertisementWithCompanyNameAndPositionNameDetail();

}
