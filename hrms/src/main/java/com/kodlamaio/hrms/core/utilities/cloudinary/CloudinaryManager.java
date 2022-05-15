package com.kodlamaio.hrms.core.utilities.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	private final Cloudinary cloudinary;

	public CloudinaryManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dgdzfni5t", 
				"api_key", "298853461875511",
				"api_secret", "cFWrJ9iTj2cfk5_AsFnUSuPR5wc", 
				"secure", true));
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file = convert(multipartFile);
			@SuppressWarnings("unchecked")
			Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<>(result);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>("Dosya yuklenmedi.");
		}
	}

	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		return file;

	}

}
