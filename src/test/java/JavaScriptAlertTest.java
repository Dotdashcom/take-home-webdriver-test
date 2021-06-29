import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.JavaScriptAlert;

public class JavaScriptAlertTest {

	private WebDriver driver = null;
	
	@Before
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
	}
	
	/*
	 * Click JS alert and assert message
	 */
	@Test
	public void clickAlertDialog() {
		
		JavaScriptAlert alertPage = new JavaScriptAlert(driver);
		
		alertPage.clickAlertButton();
		alertPage.clickOkOnAlertDialog();
		
		String result = alertPage.getResultText();
		assertTrue("Error with alert", result.equals("You successfuly clicked an alert"));
	}
	
	@Test
	public void clickOkOnConfirmDialog() {
		
		JavaScriptAlert alertPage = new JavaScriptAlert(driver);
		
		alertPage.clickConfirmButton();
		alertPage.clickOkOnConfirmDialog();
		
		String result = alertPage.getResultText();
		assertTrue("Error with confirm", result.equals("You clicked: Ok"));
		
	} 
	
	@Test
	public void clickCancelOnConfirmDialog() {
		
		JavaScriptAlert alertPage = new JavaScriptAlert(driver);
		
		alertPage.clickConfirmButton();
		alertPage.clickCancelOnConfirmDialog();
		
		String result = alertPage.getResultText();
		assertTrue("Error with confirm", result.equals("You clicked: Cancel"));

	}
	
	@Test
	public void typeAndClickOkOnPromptDialog() {
		
		JavaScriptAlert alertPage = new JavaScriptAlert(driver);
		
		alertPage.clickPromptButton();
		alertPage.clickOkOnPromptDialog("Hello World");
		
		String result = alertPage.getResultText();
		assertTrue("Error with prompt", result.equals("You entered: Hello World"));
		
	}
	
	@Test
	public void clickCancelOnPromptDialog() {
		
		JavaScriptAlert alertPage = new JavaScriptAlert(driver);
		
		alertPage.clickPromptButton();
		alertPage.clickCancelOnPromptDialog();
		
		String result = alertPage.getResultText();
		assertTrue("Error with prompt", result.equals("You entered: null"));
		
	}	
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}

