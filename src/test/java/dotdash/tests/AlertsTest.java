package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.AlertsPage;
import dotdash.pageobjects.UploadPage;
import dotdash.resources.base;

public class AlertsTest extends base{

	public WebDriver driver;
	AlertsPage ap;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("alertsUrl"));
		
	}
	
	
	@Test
	public void validateAlerts() throws IOException, InterruptedException {	
		
			 ap= new AlertsPage(driver);
			 ap.clickOnAlert();
			 ap.clickOnConfirmAlert();
			 ap.clickOnPromptAlert();
			 
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
