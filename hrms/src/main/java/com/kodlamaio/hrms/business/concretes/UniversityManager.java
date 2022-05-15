package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.UniversityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import com.kodlamaio.hrms.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService{
	
	private UniversityDao universityDao;

	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}

	@Override
	public Result add(University university) {
		this.universityDao.save(university);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<University>> getAll() {
		return new SuccessDataResult<List<University>>(this.universityDao.findAll());
	}

}
