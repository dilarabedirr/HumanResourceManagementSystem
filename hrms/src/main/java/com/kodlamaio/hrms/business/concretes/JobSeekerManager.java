package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.business.dtos.JobSeekerSearchListDto;
import com.kodlamaio.hrms.business.messages.Messages;
import com.kodlamaio.hrms.business.requests.jobseekerRequests.CreateJobSeekerRequest;
import com.kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import com.kodlamaio.hrms.core.adapters.abstracts.VerificationService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ModelMapperService modelMapperService;
	private UserCheckService userCheckService;
	private VerificationService verificationService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ModelMapperService modelMapperService,
			UserCheckService userCheckService, VerificationService verificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.modelMapperService = modelMapperService;
		this.userCheckService = userCheckService;
		this.verificationService = verificationService;
	}

	@Override
	public DataResult<List<JobSeekerSearchListDto>> getAll() {
		List<JobSeeker> result = this.jobSeekerDao.findAll();
		List<JobSeekerSearchListDto> response = result.stream()
				.map(jobSeeker -> modelMapperService.forDto().map(jobSeeker, JobSeekerSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<JobSeekerSearchListDto>>(response, Messages.jobSeekerUserListed);
	}

	@Override
	public Result add(CreateJobSeekerRequest createJobSeekerRequest) {
		Result result = BusinessRules.run(allFieldNotNull(createJobSeekerRequest),
				checkIfEmailExist(createJobSeekerRequest.getEmail()),
				checkIfNationalNumberExist(createJobSeekerRequest.getNationalNumber()),
				userCheckService.checkIfRealCustomer(createJobSeekerRequest),
				verificationService.checkIfUserVerification());
		if (result != null) {
			return result;
		}

		JobSeeker jobSeeker = modelMapperService.forRequest().map(createJobSeekerRequest, JobSeeker.class);
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.jobSeekerAdded);
	}

	private Result allFieldNotNull(CreateJobSeekerRequest createJobSeekerRequest) {
		if (createJobSeekerRequest.getFirstName() == "" || createJobSeekerRequest.getLastName() == ""
				|| createJobSeekerRequest.getNationalNumber() == "" || createJobSeekerRequest.getYearOfBirth() == ""
				|| createJobSeekerRequest.getEmail() == "" || createJobSeekerRequest.getPassword() == ""
				|| createJobSeekerRequest.getPasswordAgain() == "") {

			return new ErrorResult(Messages.fieldNotNullErrorResultMessage);
		}
		return new SuccessResult();
	}

	private Result checkIfEmailExist(String email) {
		JobSeeker jobSeeker = this.jobSeekerDao.getByEmail(email);
		if (jobSeeker != null) {
			return new ErrorResult(Messages.emailExistErrorResultMessage);
		}

		return new SuccessResult();
	}

	private Result checkIfNationalNumberExist(String nationalNumber) {
		JobSeeker jobSeeker = this.jobSeekerDao.getByNationalNumber(nationalNumber);
		if (jobSeeker != null) {
			return new ErrorResult(Messages.jobSeekerNationalNumberExistErrorResultMessage);
		}

		return new SuccessResult();
	}

}
