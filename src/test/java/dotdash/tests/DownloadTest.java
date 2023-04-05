package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.DownloadPage;
import dotdash.pageobjects.DynamicControlsPage;
import dotdash.resources.base;

public class DownloadTest extends base {
	
	public WebDriver driver;
	DownloadPage dp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("downloadUrl"));
		
	}
	
	
	@Test
	public void validateFileDownload() throws IOException, InterruptedException {	
		
			 dp= new DownloadPage(driver);
			 dp.downloadFileAndVerifyFileExists();
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
