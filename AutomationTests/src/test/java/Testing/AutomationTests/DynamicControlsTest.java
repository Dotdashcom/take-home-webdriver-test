package Testing.AutomationTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.DynamicControlsPage;
import resources.base;

public class DynamicControlsTest extends base {

		public WebDriver driver;
		DynamicControlsPage dynamiccontrol;


		@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("dynamiccontrolsUrl"));

		}


		@Test
		public void checkAddRemoveButton() {
			dynamiccontrol = new DynamicControlsPage(driver);
			String removeMessage=dynamiccontrol.removeCheckbox();
			AssertJUnit.assertEquals(removeMessage,"It's gone!");

			String addMessage=dynamiccontrol.addCheckbox();
			AssertJUnit.assertEquals(addMessage, "It's back!");

		}

		@Test
		public void checkEnableDisableButton() {
			dynamiccontrol = new DynamicControlsPage(driver);
			String enableMessage=dynamiccontrol.enableTextBox();
			AssertJUnit.assertEquals(enableMessage, "It's enabled!");

			String disableMessage=dynamiccontrol.disableTextBox();
			AssertJUnit.assertEquals(disableMessage, "It's disabled!");
		}


		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}

}
