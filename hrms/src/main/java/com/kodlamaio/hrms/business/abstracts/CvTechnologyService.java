package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvTechnology;

public interface CvTechnologyService {
	
	public DataResult<List<CvTechnology>> getAll();

	public Result add(CvTechnology cvTechnology);
}
