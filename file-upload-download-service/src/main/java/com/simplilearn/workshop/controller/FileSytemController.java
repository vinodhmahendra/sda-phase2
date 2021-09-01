package com.simplilearn.workshop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.domain.FileUploadResponse;
import com.simplilearn.workshop.services.FileStorageService;

@RestController
public class FileSytemController {
	
	private FileStorageService fileStorageService;

	public FileSytemController(FileStorageService fileStorageService) {
		super();
		this.fileStorageService = fileStorageService;
	}
	
	@PostMapping("single/upload")
	FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		
		String url = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/download/")
				.path(fileName)
				.toUriString();
		
		String contentType = file.getContentType();
		
		FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
		
		return response;
	}

}
