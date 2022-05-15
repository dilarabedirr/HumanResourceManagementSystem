package com.kodlamaio.hrms.core.utilities.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map<String, String>> upload(MultipartFile multipartFile);
}
