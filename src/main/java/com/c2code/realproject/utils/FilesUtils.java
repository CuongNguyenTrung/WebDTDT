package com.c2code.realproject.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FilesUtils {

	private String resource = "C:\\Users\\nguye\\BeginnerJava\\real-application-version-2\\src\\main\\webapp\\WEB-INF\\resources\\";
	private MultipartFile[] file;
	private String dir;

	public FilesUtils(MultipartFile[] file, String dir) {
		this.file = file;
		this.dir = dir;
		this.resource += dir + "\\";
	}

	public FilesUtils() {

	}

	public List<String> handle() {
		List<String> list = new ArrayList<>();
		for (MultipartFile f : file) {
			if(!f.isEmpty()) {
				String nameFile = f.getOriginalFilename();
				File file = new File(resource + nameFile);
				if(!file.exists()) {
					try {
						f.transferTo(file);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(dir + "/" + nameFile);
			}
		}
		return list;
	}
}
