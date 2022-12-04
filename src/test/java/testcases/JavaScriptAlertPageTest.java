package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.JavaScriptAlertPage;
import baseTest.AbstractE2E;

public class JavaScriptAlertPageTest {

	JavaScriptAlertPage javaScriptAlertPage;
	WebDriver driver;

	@Test(description = "User click JS Alert button")
	public void TC01_javaScriptAlertTest_success() {
		String actualMessage = javaScriptAlertPage.clickJSAlertButton();
		String expectedMessage = "I am a JS Alert";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(description = "User click JS Confirm button")
	public void TC02_javaScriptConfirmTest_success() {
		String actualMessage = javaScriptAlertPage.clickJSConfirmButton();
		String expectedMessage = "I am a JS Confirm";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(description = "User click JS Prompt button")
	public void TC03_javaScriptPromptTest_success() {
		String message = "Hello World!";
		String actualMessage = javaScriptAlertPage.clickJSPromptButton(message).getResults();
		String expectedMessage = "You entered: " + message;
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		javaScriptAlertPage = new JavaScriptAlertPage(driver);
		javaScriptAlertPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
