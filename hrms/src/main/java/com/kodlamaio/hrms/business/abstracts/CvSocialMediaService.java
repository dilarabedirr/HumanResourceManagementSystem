package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.CvSocialMedia;

public interface CvSocialMediaService {

	public DataResult<List<CvSocialMedia>> getAll();

	public Result add(CvSocialMedia cvSocialMedia);

}
