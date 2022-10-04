package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.DynamicControlsPage;
import dotdash.pageobjects.DynamicLoadingPage;
import dotdash.resources.base;

public class DynamicLoadingTest extends base {
	
	public WebDriver driver;
	DynamicLoadingPage dl;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("dynamicloadingUrl"));
		
	}
	
	
	@Test
	public void validateDynamicLoading() throws IOException, InterruptedException {	
		
			 dl= new DynamicLoadingPage(driver);
			 dl.clickStartAndVerifyMessage();
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
