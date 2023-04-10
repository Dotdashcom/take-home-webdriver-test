package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.DynamicLoadingPage;
import resources.base;

public class DynamicLoadingTest extends base {
	
		public WebDriver driver;
		DynamicLoadingPage loadingpage;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("dynamicloadingUrl"));

		}

		@Test
		public void checkDynamicLoading() {
			loadingpage = new DynamicLoadingPage(driver);
			String message=loadingpage.clickStart();
			AssertJUnit.assertEquals(message, "Hello World!");
		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}
}
