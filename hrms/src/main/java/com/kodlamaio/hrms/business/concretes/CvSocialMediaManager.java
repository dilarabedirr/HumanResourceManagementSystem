package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvSocialMediaDao;
import com.kodlamaio.hrms.entities.concretes.CvSocialMedia;

@Service
public class CvSocialMediaManager implements CvSocialMediaService {

	private CvSocialMediaDao cvSocialMediaDao;

	@Autowired
	public CvSocialMediaManager(CvSocialMediaDao cvSocialMediaDao) {
		super();
		this.cvSocialMediaDao = cvSocialMediaDao;
	}

	@Override
	public DataResult<List<CvSocialMedia>> getAll() {
		return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.findAll());
	}

	@Override
	public Result add(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.save(cvSocialMedia);
		return new SuccessResult("added");
	}
}
