package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.SystemAdminService;
import com.kodlamaio.hrms.business.dtos.SystemAdminSearchListDto;
import com.kodlamaio.hrms.business.messages.Messages;
import com.kodlamaio.hrms.business.requests.systemAdminRequests.CreateSystemAdminRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.SystemAdminDao;
import com.kodlamaio.hrms.entities.concretes.SystemAdmin;

@Service
public class SystemAdminManager implements SystemAdminService{
	
	private SystemAdminDao systemAdminDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public SystemAdminManager(SystemAdminDao systemAdminDao, ModelMapperService modelMapperService) {
		super();
		this.systemAdminDao = systemAdminDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<SystemAdminSearchListDto>> getAll() {
		List<SystemAdmin> result = this.systemAdminDao.findAll();
		List<SystemAdminSearchListDto> response = result.stream()
				.map(systemAdmin -> modelMapperService.forDto().map(systemAdmin, SystemAdminSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<SystemAdminSearchListDto>>(response, Messages.systemUserListed);
	}

	@Override
	public Result add(CreateSystemAdminRequest createSystemAdminRequest) {
		SystemAdmin systemAdmin = modelMapperService.forRequest().map(createSystemAdminRequest, SystemAdmin.class);
		this.systemAdminDao.save(systemAdmin);
		return new SuccessResult(Messages.systemAdminAdded);
	}

}
