package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPositionService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "iş pozisyonları listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = BusinessRules.run(isJobPositionExist(jobPosition.getPositionName()));
		if (result != null) {
			return result;
		}
		jobPositionDao.save(jobPosition);
		return new SuccessResult("iş pozisyonu eklendi.");
	}

	private Result isJobPositionExist(String positionName) {
		
		JobPosition jobPosition = this.jobPositionDao.getByPositionName(positionName);
		
		if (jobPosition != null) {
			return new ErrorResult("Bu pozisyon adı tekrar edemez");
		}
		
		return new SuccessResult();
	}

}
