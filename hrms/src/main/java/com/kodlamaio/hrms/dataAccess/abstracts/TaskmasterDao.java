package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.Taskmaster;

public interface TaskmasterDao extends JpaRepository<Taskmaster, Integer>{
	Taskmaster getByEmail(String email);
}
