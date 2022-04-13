package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.business.dtos.JobSeekerSearchListDto;
import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ModelMapperService modelMapperService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<JobSeekerSearchListDto>> getAll() {
		List<JobSeeker> result = this.jobSeekerDao.findAll();
		List<JobSeekerSearchListDto> response = result.stream()
				.map(jobSeeker -> modelMapperService.forDto().map(jobSeeker, JobSeekerSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobSeekerSearchListDto>>(response);
	}

	@Override
	public Result add(CreateJobSeekerRequest createJobSeekerRequest) {
		JobSeeker jobSeeker = modelMapperService.forRequest().map(createJobSeekerRequest, JobSeeker.class);
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi.");
	}

}
