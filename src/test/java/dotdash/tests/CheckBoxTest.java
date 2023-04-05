package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.CheckBoxPage;
import dotdash.pageobjects.HomePage;
import dotdash.pageobjects.LoginPage;
import dotdash.resources.base;

public class CheckBoxTest extends base {
	
	public WebDriver driver;
	CheckBoxPage c;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("checkboxesUrl"));
		
	}
	
	
	@Test
	public void validateCheckboxes() throws IOException, InterruptedException {		
					
			 c= new CheckBoxPage(driver);
			 Assert.assertEquals(c.getCheckbox1().isSelected(), false);	
			 c.SelectCheckbox(1);
			 Assert.assertEquals(c.getCheckbox1().isSelected(), true);	
			 Assert.assertEquals(c.getCheckbox2().isSelected(), true);
			 c.SelectCheckbox(2);
			 Assert.assertEquals(c.getCheckbox2().isSelected(), false);	
			
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	


}
