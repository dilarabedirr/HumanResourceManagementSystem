package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPositionService;
import com.kodlamaio.hrms.business.dtos.JobPositionSearchListDto;
import com.kodlamaio.hrms.business.messages.Messages;
import com.kodlamaio.hrms.business.requests.jobPositionRequests.CreateJobPositionRequest;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, ModelMapperService modelMapperService) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<JobPositionSearchListDto>> getAll() {
		List<JobPosition> result = this.jobPositionDao.findAll();
		List<JobPositionSearchListDto> response = result.stream()
				.map(jobPosition -> modelMapperService.forDto().map(jobPosition, JobPositionSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobPositionSearchListDto>>(response, Messages.jobPositionListed);
	}

	@Override
	public Result add(CreateJobPositionRequest createJobPositionRequest) {
		Result result = BusinessRules.run(isJobPositionExist(createJobPositionRequest.getPositionName()));
		if (result != null) {
			return result;
		}
		JobPosition jobPosition = modelMapperService.forRequest().map(createJobPositionRequest, JobPosition.class);
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.jobPositionAdded);
	}

	private Result isJobPositionExist(String positionName) {

		JobPosition jobPosition = this.jobPositionDao.getByPositionName(positionName);

		if (jobPosition != null) {
			return new ErrorResult(Messages.jobPositionExistErrorResultMessage);
		}

		return new SuccessResult();
	}

}
