package com.kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.business.dtos.JobAdvertisementSearchListDto;
import com.kodlamaio.hrms.business.messages.Messages;
import com.kodlamaio.hrms.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;
import com.kodlamaio.hrms.entities.dtos.JobAdvertisementDetailDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapperService modelMapperService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(
				modelMapperService.forDto(jobAdvertisementDao.findAll(), JobAdvertisementSearchListDto.class),
				Messages.jobAdvertisementListed);
	}

	@Override
	public Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = (JobAdvertisement) modelMapperService
				.forRequest(createJobAdvertisementRequest, JobAdvertisement.class);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.jobAdvertisementAdded);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getByStatus() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(
				modelMapperService.forDto(this.jobAdvertisementDao.getByStatusTrue(), JobAdvertisementDetailDto.class));
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getByStatusTrueOrderByDate() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(modelMapperService
				.forDto(this.jobAdvertisementDao.getByStatusTrueOrderByDate(), JobAdvertisementDetailDto.class));
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getByCity_cityNameAndStatusTrue(String cityName) {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(modelMapperService.forDto(
				this.jobAdvertisementDao.getByCity_cityNameAndStatusTrue(cityName), JobAdvertisementDetailDto.class));
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getByTaskmaster_companyNameAndStatusTrue(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(modelMapperService.forDto(
				this.jobAdvertisementDao.getByTaskmaster_companyNameAndStatusTrue(companyName),
				JobAdvertisementDetailDto.class));
	}

	public DataResult<List<JobAdvertisementDetailDto>> getByDateAndStatusTrue(LocalDate date) {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(modelMapperService
				.forDto(this.jobAdvertisementDao.getByDateAndStatusTrue(date), JobAdvertisementDetailDto.class));
	}

	@Transactional
	@Override
	public Result updateJobAdvertisementStatus(int jobAdvertisementId) {
		this.jobAdvertisementDao.updateJobAdvertisementStatus(jobAdvertisementId);
		return new SuccessResult(Messages.jobAdvertisementStatus);
	}
}
