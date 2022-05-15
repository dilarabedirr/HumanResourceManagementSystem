package com.kodlamaio.hrms.core.utilities.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager implements ModelMapperService {

	private ModelMapper modelMapper;

	@Autowired
	public ModelMapperManager(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> forDto(List<S> listTypeEntityClass, Class<T> targetDtoClass) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return listTypeEntityClass.stream().map(element -> modelMapper.map(element, targetDtoClass))
				.collect(Collectors.toList());
	}

	@Override
	public <T> Object forRequest(Object dtoClass, Class<T> targetEntityClass) {
		return modelMapper.map(dtoClass,targetEntityClass);
	}

//	@Override
//	public ModelMapper forDto() {
//		this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//		return modelMapper;
//	}
//
//	@Override
//	public ModelMapper forRequest() {
//		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
//		return modelMapper;
//	}

}
