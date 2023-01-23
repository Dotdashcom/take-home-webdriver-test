package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class NotificationMessagePage extends AbstractClass {
	WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Click here']")
	WebElement notificationlink;
	@FindBy(css = ".flash.notice")
	WebElement notificationtext;

	public String notificationMessage() {

		notificationlink.click();
		String message = notificationtext.getText();
		String actualmsg = message.split("\n")[0];
		return actualmsg.trim().toLowerCase();

	}

}
