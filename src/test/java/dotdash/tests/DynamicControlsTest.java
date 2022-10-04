package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.DynamicContentPage;
import dotdash.pageobjects.DynamicControlsPage;
import dotdash.resources.base;

public class DynamicControlsTest extends base {

	public WebDriver driver;
	DynamicControlsPage dc;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("dynamiccontrolsUrl"));
		
	}
	
	
	@Test
	public void validateDynamicContent() throws IOException, InterruptedException {	
		
			 dc= new DynamicControlsPage(driver);
			 dc.addRemoveCheckbox();
			 dc.enableDisableTextfield();
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
