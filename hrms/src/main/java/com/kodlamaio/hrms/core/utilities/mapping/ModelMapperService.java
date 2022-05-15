package com.kodlamaio.hrms.core.utilities.mapping;

import java.util.List;

//import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
//	ModelMapper forDto();
//	ModelMapper forRequest();
	
	
	<S,T> List<T> forDto(List<S> listTypeEntityClass, Class<T> targetDtoClass);

	<T> Object forRequest(Object dtoClass, Class<T> targetEntityClass);
}
