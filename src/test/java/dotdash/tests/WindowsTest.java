package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.UploadPage;
import dotdash.pageobjects.WindowsPage;
import dotdash.resources.base;

public class WindowsTest extends base{

	public WebDriver driver;
	WindowsPage wp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("windowsUrl"));
		
	}
	
	
	@Test
	public void validateNewWindowText() throws IOException, InterruptedException {	
		
			 wp= new WindowsPage(driver);
			 wp.navigateToNewWindowAndVerifyText("New Window");
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
