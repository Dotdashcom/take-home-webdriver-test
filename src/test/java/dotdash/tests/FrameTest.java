package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.FloatingPage;
import dotdash.pageobjects.IframePage;
import dotdash.resources.base;

public class FrameTest extends base{
	
	public WebDriver driver;
	IframePage ip;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("frameUrl"));
		
	}
	
	
	@Test
	public void validateFileUpload() throws IOException, InterruptedException {	
		
			 ip= new IframePage(driver);
			 ip.switchToFrameAndType("Hi there iframe");
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
