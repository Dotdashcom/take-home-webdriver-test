package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.IFramePage;
import baseTest.AbstractE2E;

public class IFramePageTest {

	IFramePage iFramePage;
	WebDriver driver;

	@Test(description = "User can write to iframe")
	public void TC01_iFrameTest_success() {
		String message = "Hello World.";
		iFramePage.writeToIframe(message);
		String actualText = iFramePage.getText();
		Assert.assertEquals(actualText, message);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		iFramePage = new IFramePage(driver);
		iFramePage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
