package com.kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.business.abstracts.CvPhotoService;
import com.kodlamaio.hrms.business.abstracts.CvService;
import com.kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvPhotoDao;
import com.kodlamaio.hrms.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService {
	
	private CvPhotoDao cvPhotoDao;
	private CloudinaryService cloudinaryService;
	private CvService cvService;

	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao, CloudinaryService cloudinaryService,CvService cvService) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.cloudinaryService = cloudinaryService;
		this.cvService=cvService;
	}

	@Override
	public Result add(MultipartFile multipartFile,int cvId) {
		var result = this.cloudinaryService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var cv = this.cvService.getById(cvId).getData();
		CvPhoto cvPhoto  = new CvPhoto(); //modelMapperService.forRequest().map(createCarImageRequest,CarImage.class);
		cvPhoto.setPhotoPath(result.getData().get("url"));
		cvPhoto.setCv(cv);
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("image added");
	}

}
