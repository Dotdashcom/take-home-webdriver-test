package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.IframePage;
import resources.base;

public class IFrameTest extends base{

		public WebDriver driver;
		IframePage iframe;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("frameUrl"));

		}


		@Test
		public void switchAndCheckText() {
			iframe = new IframePage(driver);
			String expectedText="This is iFrame";
			iframe.switchAndTypeText(expectedText);
			String frameText=iframe.verifyText();
			Assert.assertEquals(frameText, expectedText);
		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}
}
