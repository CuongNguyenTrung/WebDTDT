package com.c2code.realproject.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ListMultipartUtils {

	private String resource = "C:\\Users\\nguye\\BeginnerJava\\real-application-version-2\\src\\main\\webapp\\WEB-INF\\resources\\";
	private String dir;
	private List<MultipartFile> files;
	public ListMultipartUtils(String dir, List<MultipartFile> files) {
		this.dir = dir;
		this.files = files;
	}
	
	public ListMultipartUtils(String dir) {
		this.dir = dir;
	}
	
	public List<String> handle(){
		List<String> result = new ArrayList<>();
		for (MultipartFile file : files) {
			if(!file.isEmpty()) {
				String name = file.getOriginalFilename();
				File tarFile = new File(resource + dir + "\\" + name);
				if(!tarFile.exists()) {
					try {
						file.transferTo(tarFile);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				result.add(dir + "/" + name);
			}
		}
		return result;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
}
