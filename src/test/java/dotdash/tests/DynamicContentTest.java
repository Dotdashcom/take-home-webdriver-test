package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.DropdownPage;
import dotdash.pageobjects.DynamicContentPage;
import dotdash.resources.base;

public class DynamicContentTest extends base {

	public WebDriver driver;
	DynamicContentPage dp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("dynamiccontUrl"));
		
	}
	
	
	@Test
	public void validateDynamicContent() throws IOException, InterruptedException {	
		
			 dp= new DynamicContentPage(driver);
			 dp.refreshPage(5);
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
