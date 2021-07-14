package com.theInternetUtilities;

import java.io.File;

public class CommonActions {

	public void deleteFiles(String fileDirectory) {
		File directory = new File(fileDirectory);
		if(directory.exists()) {
			while(directory.listFiles().length>0) {
				String files[] = directory.list();
				for(String temp: files) {
					File fileDelete = new File(directory,temp);
					fileDelete.delete();
				}
			}
			
		}
	}
	
	public String getFileName(String fileDirectory) {
		File directory = new File(fileDirectory);
		String fileName = "";
		if(directory.exists()) {
			if(directory.listFiles().length>0) {
				File[] files = directory.listFiles();
				fileName = files[0].getName();
			}
		}
		return fileName;
	}
	
}
