package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.TaskmasterService;
import com.kodlamaio.hrms.business.dtos.TaskmasterSearchListDto;
import com.kodlamaio.hrms.business.requests.taskmasterRequests.CreateTaskmasterRequest;
import com.kodlamaio.hrms.core.adapters.abstracts.HrmsVerificationService;
import com.kodlamaio.hrms.core.adapters.abstracts.VerificationService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.messages.Message;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TaskmasterDao;
import com.kodlamaio.hrms.entities.concretes.Taskmaster;

@Service
public class TaskmasterManager implements TaskmasterService {

	private TaskmasterDao taskmasterDao;
	private ModelMapperService modelMapperService;
	private VerificationService verificationService;
	private HrmsVerificationService hrmsVerificationService;

	@Autowired
	public TaskmasterManager(TaskmasterDao taskmasterDao, ModelMapperService modelMapperService,
			VerificationService verificationService, HrmsVerificationService hrmsVerificationService) {
		super();
		this.taskmasterDao = taskmasterDao;
		this.modelMapperService = modelMapperService;
		this.verificationService = verificationService;
		this.hrmsVerificationService = hrmsVerificationService;
	}

	@Override
	public DataResult<List<TaskmasterSearchListDto>> getAll() {
		List<Taskmaster> result = this.taskmasterDao.findAll();
		List<TaskmasterSearchListDto> response = result.stream()
				.map(taskmaster -> modelMapperService.forDto().map(taskmaster, TaskmasterSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<TaskmasterSearchListDto>>(response, Message.taskmasterUserListed);
	}

	@Override
	public Result add(CreateTaskmasterRequest createTaskmasterRequest) {
		Result result = BusinessRules.run(
				checkIfCorporateEmail(createTaskmasterRequest.getWebSiteName(), createTaskmasterRequest.getEmail()),
				allFieldNotNull(createTaskmasterRequest), verificationService.checkIfUserVerification(),
				hrmsVerificationService.checkIfHrmsUserVerification(), checkIfEmailExist(createTaskmasterRequest.getEmail()));
		if (result != null) {
			return result;
		}
		Taskmaster taskmaster = modelMapperService.forRequest().map(createTaskmasterRequest, Taskmaster.class);
		this.taskmasterDao.save(taskmaster);
		return new SuccessResult(Message.taskmasterAdded);
	}

	private Result checkIfCorporateEmail(String website, String email) {
		return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(Message.emailNotCorporate);
	}

	private Result allFieldNotNull(CreateTaskmasterRequest createTaskmasterRequest) {
		if (createTaskmasterRequest.getCompanyName() == "" || createTaskmasterRequest.getWebSiteName() == ""
				|| createTaskmasterRequest.getEmail() == "" || createTaskmasterRequest.getPassword() == ""
				|| createTaskmasterRequest.getPasswordAgain() == "" || createTaskmasterRequest.getPhoneNumber() == "") {

			return new ErrorResult(Message.fieldNotNullErrorResultMessage);
		}
		return new SuccessResult();
	}
	
	private Result checkIfEmailExist(String email) {
		Taskmaster taskmaster = this.taskmasterDao.getByEmail(email);
		if (taskmaster != null) {
			return new ErrorResult(Message.emailExistErrorResultMessage);
		}

		return new SuccessResult();
	}

}
