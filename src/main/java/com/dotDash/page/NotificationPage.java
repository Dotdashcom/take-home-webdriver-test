package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class NotificationPage extends BasePage {
	private WebDriver driver;

	public NotificationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Notification Message']")
	private WebElement notificationMessageHeader;
	@FindBy(id = "flash")
	private WebElement notificationLabel;
	@FindBy(linkText = "Click here")
	private WebElement clickHereLink;
	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToNotificationPage() {
		navigateTo(TestProperties.getProperty("NOTIFICATION_URL"));
		assertEquals("Hover Page Elements Header",checkWebElementExist(notificationMessageHeader), true);
	}
	/**
	 * To Validate Notification  functionality
	 * @author Seb Geb
	 */
	
	public void validateNotificationFunctionality() {
		List<String> listNotifications=new ArrayList<>();
		listNotifications.add("Action unsuccesful, please try again\n" + "×");
		listNotifications.add("Action successful\n" +"×");
		String text =null;
		for(int index=1;index<=5;index++){
			clickOnElement(clickHereLink);
			text = notificationLabel.getText();
			assertEquals("Validate Notifaction Message:" + text, listNotifications.contains(text), true);
		}
	}
}