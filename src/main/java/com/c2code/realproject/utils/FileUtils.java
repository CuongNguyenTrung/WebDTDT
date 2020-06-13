package com.c2code.realproject.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	private String resource = "C:\\Users\\nguye\\BeginnerJava\\real-application-version-2\\src\\main\\webapp\\WEB-INF\\resources\\";
	private MultipartFile file;
	private String dir;

	public FileUtils(MultipartFile file, String dir) {
		this.file = file;
		this.dir = dir;
		this.resource += dir + "\\";
	}

	public FileUtils() {

	}

	public String handle() {
		if (file.isEmpty()) return null;
		String name = file.getOriginalFilename();
		File newFile = new File(resource + name);
		if(!newFile.exists()) {
			try {
				file.transferTo(newFile);
				return dir + "/" + name;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			return dir + "/" + name;
		}
		return null;
	}
}
