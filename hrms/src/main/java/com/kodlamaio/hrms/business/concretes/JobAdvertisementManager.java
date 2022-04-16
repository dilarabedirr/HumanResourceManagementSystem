package com.kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response, Messages.jobAdvertisementListed);
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getByCity_CityId(int cityId) {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByCity_CityId(cityId);
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response, Messages.jobAdvertisementListed);
	}

	@Override
	public Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = modelMapperService.forRequest().map(createJobAdvertisementRequest,
				JobAdvertisement.class);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.jobAdvertisementAdded);
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getByStatus() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByStatusTrue();
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response);
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getByStatusTrueOrderByDate() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByStatusTrueOrderByDate();
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response);
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getByTaskmasterIdAndStatusTrue(int taskmasterId) {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByTaskmasterIdAndStatusTrue(taskmasterId);
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response);
	}

	@Override
	public DataResult<List<JobAdvertisementSearchListDto>> getByDateAndStatusTrue(LocalDate date) {
		List<JobAdvertisement> result = this.jobAdvertisementDao.getByDateAndStatusTrue(date);
		List<JobAdvertisementSearchListDto> response = result.stream().map(jobAdvertisement -> modelMapperService
				.forDto().map(jobAdvertisement, JobAdvertisementSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<JobAdvertisementSearchListDto>>(response);
	}

}
