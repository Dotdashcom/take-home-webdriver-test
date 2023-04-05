package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.FloatingPage;
import dotdash.pageobjects.UploadPage;
import dotdash.resources.base;

public class FloatingMenuTest extends base {
	
	public WebDriver driver;
	FloatingPage fp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("floatingUrl"));
		
	}
	
	
	@Test
	public void validateFileUpload() throws IOException, InterruptedException {	
		
			 fp= new FloatingPage(driver);
			 fp.scrollAndVerifyMenu();
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
