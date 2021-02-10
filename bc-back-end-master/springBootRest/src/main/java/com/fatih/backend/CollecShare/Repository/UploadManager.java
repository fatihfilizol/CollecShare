package com.fatih.backend.CollecShare.Repository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class UploadManager {

	//@Value("${upload.path}")
	//private String path;

	public String uploadFile(MultipartFile file, String path) {
		
		if (file.isEmpty()) {
			return "Failed to store empty file";
		}
		try {
			var fileName = file.getOriginalFilename();
			var is = file.getInputStream();

			Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
			

		} catch (IOException e) {
			return "hatali";
		}
		return "basarili";
	}
	
	public byte[] getUrun(String imageUrl) throws IOException {
		return Files.readAllBytes(Paths.get(imageUrl));
		
		
	}
	
public void deleteFile(String path) {
		
		try {
			Path fileToDeletePath = Paths.get(path);
			Files.delete(fileToDeletePath);

		} catch (IOException e) {
		
		}
		
	}

	

}
