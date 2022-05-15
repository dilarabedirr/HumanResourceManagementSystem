package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import com.kodlamaio.hrms.entities.concretes.UniversityDepartment;

@Service
public class UniversityDepartmentManager implements UniversityDepartmentService{
	
	private UniversityDepartmentDao universityDepartmentDao;

	@Autowired
	public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
		super();
		this.universityDepartmentDao = universityDepartmentDao;
	}

	@Override
	public Result add(UniversityDepartment universityDepartment) {
		this.universityDepartmentDao.save(universityDepartment);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<UniversityDepartment>> getAll() {
		return new SuccessDataResult<List<UniversityDepartment>>(this.universityDepartmentDao.findAll());
	}

}
