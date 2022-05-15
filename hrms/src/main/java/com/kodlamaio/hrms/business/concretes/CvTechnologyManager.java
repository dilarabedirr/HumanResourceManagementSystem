package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvTechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvTechnologyDao;
import com.kodlamaio.hrms.entities.concretes.CvTechnology;

@Service
public class CvTechnologyManager implements CvTechnologyService{
	
	private CvTechnologyDao cvTechnologyDao;

	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		super();
		this.cvTechnologyDao = cvTechnologyDao;
	}

	@Override
	public DataResult<List<CvTechnology>> getAll() {
		return new SuccessDataResult<List<CvTechnology>>(this.cvTechnologyDao.findAll());
	}

	@Override
	public Result add(CvTechnology cvTechnology) {
		this.cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("added.");
	}
}
