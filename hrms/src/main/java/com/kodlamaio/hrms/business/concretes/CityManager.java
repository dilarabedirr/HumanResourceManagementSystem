package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.business.dtos.CitySearchListDto;
import com.kodlamaio.hrms.business.messages.Messages;
import com.kodlamaio.hrms.business.requests.cityRequests.CreateCityRequest;
import com.kodlamaio.hrms.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
		super();
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CitySearchListDto>> getAll() {
		return new SuccessDataResult<List<CitySearchListDto>>(
				modelMapperService.forDto(cityDao.findAll(), CitySearchListDto.class), Messages.cityListed);
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) {
		City city = (City) modelMapperService.forRequest(createCityRequest, City.class);
		this.cityDao.save(city);
		return new SuccessResult(Messages.cityAdded);
	}

}
