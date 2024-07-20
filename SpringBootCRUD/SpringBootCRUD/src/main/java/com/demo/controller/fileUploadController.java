package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Helper.fileupload;

@RestController
public class fileUploadController {

	@Autowired
	private fileupload fileuploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("profileCV") MultipartFile file) {
		try {
			// System.out.println(file.getOriginalFilename());
			// System.out.println(file.getSize());
			// System.out.println(file.getContentType());
			// System.out.println(file.getName());

			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must Contain a valid file");

			}
			if (!file.getContentType().equals("application/pdf")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("FIle must contain a valid format pdf");
			}

			boolean f = fileuploadHelper.fileupload(file);

			if(f){
				return ResponseEntity.ok("uploaded");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong try again");
	}

}
