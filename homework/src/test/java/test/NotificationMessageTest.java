package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.NotificationMessagePage;
import util.BrowserFactory;

public class NotificationMessageTest {

	WebDriver driver;

	@Test
	public void notificationCheck() throws InterruptedException {

		driver = BrowserFactory.init();

		NotificationMessagePage notificationPage = PageFactory.initElements(driver, NotificationMessagePage.class);
		notificationPage.notificationMenu();
		notificationPage.clickElement();

		// closing browser
		BrowserFactory.tearDown();

	}

}
