package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvLanguageService;
import com.kodlamaio.hrms.business.requests.cvLanguageRequests.CreateCvLanguageRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import com.kodlamaio.hrms.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao, ModelMapperService modelMapperService) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll());
	}

	@Override
	public Result add(CreateCvLanguageRequest createCvLanguageRequest) {
		CvLanguage cvLanguage=(CvLanguage) modelMapperService.forRequest(createCvLanguageRequest, CvLanguage.class);
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult();
	}

}
