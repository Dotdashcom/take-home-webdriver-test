package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
	WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Click here")
	private WebElement link;
	
	public void clickOnLink() {
		link.click();
	}
	
	@FindBy(id="flash")
	private WebElement notification;
	
	public String checkNotificationMessage() {
		System.out.println(notification.getText().split("\n")[0]);
		String notificationMessage=notification.getText().split("\n")[0];
		return notificationMessage;
	}
}
