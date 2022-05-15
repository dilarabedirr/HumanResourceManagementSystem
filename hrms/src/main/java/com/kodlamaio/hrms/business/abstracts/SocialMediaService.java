package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	
	public DataResult<List<SocialMedia>> getAll();
	
	public Result add(SocialMedia socialMedia);
}
