package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvEducationService;
import com.kodlamaio.hrms.business.dtos.CvEducationSearchListDto;
import com.kodlamaio.hrms.business.requests.cvEducationRequests.CreateCvEducationRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvEducationDao;
import com.kodlamaio.hrms.entities.concretes.CvEducation;

@Service
public class CvEducationManager implements CvEducationService {

	private CvEducationDao cvEducationDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao, ModelMapperService modelMapperService) {
		super();
		this.cvEducationDao = cvEducationDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CvEducationSearchListDto>> getAll() {
		return new SuccessDataResult<List<CvEducationSearchListDto>>(
				modelMapperService.forDto(this.cvEducationDao.findAll(), CvEducationSearchListDto.class));
	}

	@Override
	public Result add(CreateCvEducationRequest createCvEducationRequest) {
		CvEducation cvEducation = (CvEducation) modelMapperService.forRequest(createCvEducationRequest,
				CvEducation.class);
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<CvEducationSearchListDto>> findByOrderByYearOfGraduationDesc() {
		return new SuccessDataResult<List<CvEducationSearchListDto>>(modelMapperService
				.forDto(this.cvEducationDao.findByOrderByYearOfGraduationDesc(), CvEducationSearchListDto.class));
	}

}
