package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dotdash.pageobjects.DropdownPage;
import dotdash.resources.base;

public class DropdownTest extends base {

	public WebDriver driver;
	DropdownPage dp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("dropdownUrl"));
		
	}
	
	
	@Test
	public void validateDropdown() throws IOException, InterruptedException {	
		
			 dp= new DropdownPage(driver);
			 dp.selectOption("Option 1");
			 dp.selectOption("Option 2");
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
