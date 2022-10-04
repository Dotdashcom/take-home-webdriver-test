package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.JavaScriptPage;
import dotdash.resources.base;

public class JavaScriptTest extends base{

	public WebDriver driver;
	JavaScriptPage jp;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("javascriptUrl"));
		
	}
	
	
	@Test
	public void validateJsErrors() throws IOException, InterruptedException {	
		
			 jp= new JavaScriptPage(driver);
			 jp.captureJsErrorAndVerify("Cannot read properties of undefined (reading 'xyz')");
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
