package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.NotificationMessagePage;
import resources.base;

public class NotificationMessageTest extends base {
	public WebDriver driver;
	NotificationMessagePage notification;


	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("notificationsUrl"));

	}


	@Test
	public void notificationMessage() throws IOException, InterruptedException {	

		notification= new NotificationMessagePage(driver);
		notification.renderNotification("Action successful", "Action unsuccesful, please try again");



	}


	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}
