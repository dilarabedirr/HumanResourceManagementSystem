package com.kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByCity_CityId(int cityId);

	List<JobAdvertisement> getByStatusTrue();

	List<JobAdvertisement> getByStatusTrueOrderByDate();
	
	List<JobAdvertisement> getByTaskmasterIdAndStatusTrue(int taskmasterId);
	
	List<JobAdvertisement> getByDateAndStatusTrue(LocalDate date);
	
}
