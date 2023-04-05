package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.CheckBoxPage;
import dotdash.pageobjects.ContextPage;
import dotdash.resources.base;

public class ContextTest extends base {
	
	public WebDriver driver;
	ContextPage c;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("contextUrl"));
		
	}
	
	
	@Test
	public void validateCheckboxes() throws IOException, InterruptedException {	
		
			 c= new ContextPage(driver);
			 Actions actions = new Actions(driver);
			 actions.contextClick(c.getContext()).perform();
			 Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu"); 
			 driver.switchTo().alert().accept();
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
