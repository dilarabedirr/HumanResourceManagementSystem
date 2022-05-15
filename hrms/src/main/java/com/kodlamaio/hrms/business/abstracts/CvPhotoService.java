package com.kodlamaio.hrms.business.abstracts;



import org.springframework.web.multipart.MultipartFile;


import com.kodlamaio.hrms.core.utilities.results.Result;

public interface CvPhotoService {
	
//	public DataResult<List<CvPhoto>> getAll();
	
	public Result add(MultipartFile multipartFile,int cvId);

}
