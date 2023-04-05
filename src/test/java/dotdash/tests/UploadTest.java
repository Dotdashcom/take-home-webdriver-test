package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.DownloadPage;
import dotdash.pageobjects.UploadPage;
import dotdash.resources.base;

public class UploadTest extends base{
	
	public WebDriver driver;
	UploadPage up;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("uploadUrl"));
		
	}
	
	
	@Test
	public void validateFileUpload() throws IOException, InterruptedException {	
		
			 up= new UploadPage(driver);
			 up.uploadFile();
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
