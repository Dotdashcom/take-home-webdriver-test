package com.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.base.Base;

public class FileDownloadTest extends Base{
	
	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName","chrome");
		options.setCapability("platform",false);
		
		Map<String, Object> prefs= new HashMap<>();
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs",prefs);
		
		driver=new ChromeDriver(options);		
	}
	
	@Test
	public void verifyTheFileDownloadTest() throws InterruptedException {
		driver.get("http://localhost:7080/download");
		driver.findElement(By.cssSelector(".example > a:nth-child(2)")).click();
		Thread.sleep(2000);
		File listOfFiles[]=folder.listFiles();
		Assert.assertTrue(listOfFiles.length>0);
		for(File file: listOfFiles) {
			Assert.assertTrue(file.length()>0);
		}
	}
	
	@AfterMethod
	public void tearDown() {		
		for(File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete();
		driver.quit();
	}	
}
