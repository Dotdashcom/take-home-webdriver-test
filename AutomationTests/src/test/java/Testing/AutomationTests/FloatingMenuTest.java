package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.FloatingMenuPage;
import resources.base;

public class FloatingMenuTest extends base {

		public WebDriver driver;
		FloatingMenuPage floatingmenu;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("floatingUrl"));

		}


		@Test
		public void checkFloatingMenu() {
			floatingmenu = new FloatingMenuPage(driver);
			//before scrolling down
			Assert.assertTrue(floatingmenu.checkFloatingMenu());
			floatingmenu.scrollDown();
			//after scrolling down
			Assert.assertTrue(floatingmenu.checkFloatingMenu());
		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}

}
