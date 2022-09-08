package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import util.BrowserFactory;

public class NotificationMessageTest extends BrowserFactory {
	static NotificationMessagePage notificationMessagePage;

	@BeforeMethod
	public static void beforeTests() {
		init("notification_message_rendered");
		notificationMessagePage = PageFactory.initElements(driver, NotificationMessagePage.class);
	}

	@Test(priority = 1)
	public static void testClicksOnTheClickHereLinkAMultipleTimesAndTestAssertsAMessageWillShowOnClick() {				
		notificationMessagePage.clickClickHereHyperlinkForTheFirstTime();
		
//		Open declaration of method below for commits of code 
		
		notificationMessagePage.validateOneOfTheMessagesWillGenerateOnFirstClick();
		
//		Unable to validate the next refreshes because I could not validate the first one.
		
		notificationMessagePage.clickClickHereHyperlinkForTheSecondTime();
		notificationMessagePage.clickClickHereHyperlinkForTheThirdTime();
	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
