package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.AbstractE2E;
import utilities.TestHandler;

public class NotificationMessagePage {

	WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[(text()='Click here')]")
	WebElement linkClickHere;

	@FindBy(css = "div#flash")
	WebElement notificationElement;

	public void clickLink() {
		linkClickHere.click();
	}

	public String getNotificationMessagesOnClick() {
		TestHandler.waitForElementToBeVisible(notificationElement, 5);

		if (notificationElement.getText() == null || notificationElement.getText().isEmpty()) {
			return "";
		}
		return notificationElement.getText().split("\n")[0].trim();
	}

	// get url
	public NotificationMessagePage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/notification_message_rendered");
		return this;
	}
}
