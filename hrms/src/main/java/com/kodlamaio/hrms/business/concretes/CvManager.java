package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvService;
import com.kodlamaio.hrms.business.dtos.CvDetailDto;
import com.kodlamaio.hrms.business.dtos.CvSearchListDto;
import com.kodlamaio.hrms.business.requests.cvRequests.CreateCvRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvDao;
import com.kodlamaio.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService{
	
	private CvDao cvDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CvManager(CvDao cvDao, ModelMapperService modelMapperService) {
		super();
		this.cvDao = cvDao;
		this.modelMapperService=modelMapperService;
	}

	@Override
	public DataResult<List<CvSearchListDto>> getAll() {
		return new SuccessDataResult<List<CvSearchListDto>>(
				modelMapperService.forDto(this.cvDao.findAll(), CvSearchListDto.class),"cv listelendi.");
	}

	@Override
	public Result add(CreateCvRequest createCvRequest) {
		Cv cv =(Cv) modelMapperService.forRequest(createCvRequest, Cv.class);
		this.cvDao.save(cv);
		return new SuccessResult("Özgeçmiş eklendi.");
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.findById(id).get(),"user listed");
	}

	@Override
	public DataResult<List<CvDetailDto>> getDetailDtoById(int id) {
		return new SuccessDataResult<List<CvDetailDto>>(modelMapperService.forDto(this.cvDao.findAll(), CvDetailDto.class));
	}

}
