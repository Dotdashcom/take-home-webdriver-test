package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.JavaScriptAlertPage;
import testbase.TestBase;

public class JavaScriptAlertPageTest {

	JavaScriptAlertPage javaScriptAlertPage;
	WebDriver driver;

	@Test(priority = 1, description = "User click JS Alert button")
	public void javaScriptAlertTest() {
		String actualMessage = javaScriptAlertPage.clickJSAlertButton();
		String expectedMessage = "I am a JS Alert";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 2, description = "User click JS Confirm button")
	public void javaScriptConfirmTest() {
		String actualMessage = javaScriptAlertPage.clickJSConfirmButton();
		String expectedMessage = "I am a JS Confirm";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 3, description = "User click JS Prompt button")
	public void javaScriptPromptTest() {
		String message = "Hello World!";
		String actualMessage = javaScriptAlertPage.clickJSPromptButton(message).getResults();
		String expectedMessage = "You entered: " + message;
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		javaScriptAlertPage = new JavaScriptAlertPage(driver);
		javaScriptAlertPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
