package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CvExperienceService;
import com.kodlamaio.hrms.business.dtos.CvExperienceSearchListDto;
import com.kodlamaio.hrms.business.requests.cvExperienceRequests.CreateCvExperienceRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import com.kodlamaio.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao, ModelMapperService modelMapperService) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CvExperienceSearchListDto>> getAll() {
		return new SuccessDataResult<List<CvExperienceSearchListDto>>(modelMapperService.
				forDto(this.cvExperienceDao.findAll(), CvExperienceSearchListDto.class));
	}

	@Override
	public Result add(CreateCvExperienceRequest createCvExperienceRequest) {
		CvExperience cvExperience =(CvExperience) modelMapperService.forRequest(createCvExperienceRequest, CvExperience.class);
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CvExperienceSearchListDto>> findByOrderByYearOfEndingDesc() {
		return new SuccessDataResult<List<CvExperienceSearchListDto>>(modelMapperService.
				forDto(this.cvExperienceDao.findByOrderByYearOfEndingDesc(), CvExperienceSearchListDto.class));
	}

}
