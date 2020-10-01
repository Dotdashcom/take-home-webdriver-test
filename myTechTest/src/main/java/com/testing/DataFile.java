package com.testing;

import java.io.File;

public interface DataFile {

	File appDir = new File("ProjectData");	   
	File testDataFile = new File(appDir, "testData.xlsx");
	
	Xls_Reader d = new Xls_Reader(testDataFile.getAbsolutePath());

	public String validUserName = d.getCellData("Credentials", 1, 1);
	public String validPassword = d.getCellData("Credentials", 1, 2);
	public String invalidUserName = d.getCellData("Credentials", 1, 3);
	public String invalidPassword = d.getCellData("Credentials", 1, 4);
	
	public String baseURL = d.getCellData("URL", 1, 1);
	public String loginURL = d.getCellData("URL", 1, 2);
	public String checkboxURL = d.getCellData("URL", 1, 3);
	public String contextMenuURL = d.getCellData("URL", 1, 4);
	public String dragAndDropURL = d.getCellData("URL", 1, 5);
	public String dropdownURL = d.getCellData("URL", 1, 6);
	public String dynamicContentURL = d.getCellData("URL", 1, 7);
	public String dynamicControlsURL = d.getCellData("URL", 1, 8);
	public String dynamicLoadingURL = d.getCellData("URL", 1, 9);
	public String downloadFileURL = d.getCellData("URL", 1, 10);
	public String uploadFileURL = d.getCellData("URL", 1, 11);
	public String floatingMenuURL = d.getCellData("URL", 1, 12);
	public String iFrameURL = d.getCellData("URL", 1, 13);
	public String mouseHoverURL = d.getCellData("URL", 1, 14);
	public String javaScriptAlertURL = d.getCellData("URL", 1, 15);
	public String javaScriptErrorURL = d.getCellData("URL", 1, 16);
	public String newTabURL = d.getCellData("URL", 1, 17);
	public String messageNotificationURL = d.getCellData("URL", 1, 18);
	
	
}