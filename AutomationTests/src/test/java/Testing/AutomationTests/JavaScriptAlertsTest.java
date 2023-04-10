package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.JavascriptAlertsPage;
import resources.base;

public class JavaScriptAlertsTest extends base {
	public WebDriver driver;
	JavascriptAlertsPage javascriptAlerts;


	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("alertsUrl"));

	}


	@Test
	public void validateAlerts() throws IOException, InterruptedException {	

		javascriptAlerts= new JavascriptAlertsPage(driver);
			String message;

			message=javascriptAlerts.checkJSAlert();
			Assert.assertEquals(message, "You successfuly clicked an alert");

			message=javascriptAlerts.checkJSConfirm("accept");
			Assert.assertEquals(message,"You clicked: Ok");
			message=javascriptAlerts.checkJSConfirm("cancel");
			Assert.assertEquals(message,"You clicked: Cancel");

			message=javascriptAlerts.checkJSPrompt("accept", "123");
			Assert.assertEquals(message,"You entered: 123");
			message=javascriptAlerts.checkJSPrompt("cancel", "");
			Assert.assertEquals(message,"You entered: null");
		
	}


	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
