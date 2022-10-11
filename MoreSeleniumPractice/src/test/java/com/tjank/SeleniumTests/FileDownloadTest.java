package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.FileDownloadPage;
import com.tjank.PageObjectModel.WebPage;

public class FileDownloadTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void fileDownloadTest() {
		FileDownloadPage dnPage = new FileDownloadPage();
		dnPage.setup();
		dnPage.waitForPageToLoad();
		dnPage.downloadFile();
		dnPage.verifyFileDownloaded();
	}
}
