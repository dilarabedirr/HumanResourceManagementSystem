package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.TechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import com.kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;

	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Teknolojiler Listelendi");
	}

	@Override
	public Result add(Technology technology) {
		this.technologyDao.save(technology);
		return new SuccessResult("added.");
	}

}