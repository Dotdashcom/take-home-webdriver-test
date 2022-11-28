package com.testcases;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownload {

	ChromeDriver driver;
	String downloadFilepath;

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		 System.setProperty("webdriver.chrome.driver","/Users/h/Downloads/chromedriver-1" );
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);

	    downloadFilepath = System.getProperty("user.dir");
		chromePrefs.put("download.default_directory", downloadFilepath);

		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);

		String url = "http://localhost:7080/download";
		driver.manage().window().maximize();
		driver.get(url);
		
	}

	@Test
	public void clickLink() throws InterruptedException {

		driver.findElement(By.linkText("demo.txt")).click();
		File file = new File(downloadFilepath + "//demo.txt");
		System.out.println(downloadFilepath);
		boolean checkFileStatus = file.exists();
		System.out.println(file.exists());
		if(file.exists())
		{
			System.out.println("File Got Successfully Downloaded");
		}
		Assert.assertEquals(true, checkFileStatus);//Assert
		
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
