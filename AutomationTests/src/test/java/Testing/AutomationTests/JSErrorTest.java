package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.JSErrorPage;
import resources.base;

public class JSErrorTest extends base{
	public WebDriver driver;
	JSErrorPage errorPage;


	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("javascriptUrl"));

	}


	@Test
	public void validateJsErrors() throws IOException, InterruptedException {	

		errorPage= new JSErrorPage(driver);
		LogEntries jsErrors=driver.manage().logs().get(LogType.BROWSER);
		Assert.assertTrue(jsErrors.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));


	}


	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}
