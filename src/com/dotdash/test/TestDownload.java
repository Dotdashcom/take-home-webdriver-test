package com.dotdash.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DownloadPage;
import com.dotdash.util.DriverUtil;

public class TestDownload extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", createSavingFolderPath());
         
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        
        driver = new ChromeDriver(options);
	}
	
	@Test(description = "Test downloading file")
	private void testDownload() {
		DownloadPage downLoadPage = navigateTo(driver, DownloadPage.class);
		downLoadPage.verifyPage();

		String fileName = downLoadPage.downloadFile();
		verifyFileOnDisk(fileName);
	}
	
	private String createSavingFolderPath() {
        StringBuilder savingFolder = new StringBuilder(System.getProperty("user.dir"));
        savingFolder.append(File.separator);
        savingFolder.append("temp");
        return savingFolder.toString();
	}
	
	private void verifyFileOnDisk(String fileName) {
		String fullPath = createSavingFolderPath() + File.separator + fileName;
		assertTrue(new File(fullPath).exists());
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
