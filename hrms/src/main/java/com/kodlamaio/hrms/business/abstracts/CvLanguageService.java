package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.business.requests.cvLanguageRequests.CreateCvLanguageRequest;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvLanguage;

public interface CvLanguageService {
	
	public DataResult<List<CvLanguage>> getAll();
	
	public Result add(CreateCvLanguageRequest createCvLanguageRequest);

}
