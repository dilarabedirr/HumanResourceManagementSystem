package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.UniversityDepartment;

public interface UniversityDepartmentService {

	Result add(UniversityDepartment universityDepartment);

	DataResult<List<UniversityDepartment>> getAll();

}
