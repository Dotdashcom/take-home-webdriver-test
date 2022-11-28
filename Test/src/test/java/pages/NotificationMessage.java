package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessage {


	WebDriver driver;

	public NotificationMessage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//*[@id=\"content\"]/div/p/a")
	WebElement clickHereLink;

	@FindBy(id = "flash")
	WebElement notificationMessage;

	public NotificationMessage ClickLink() {

		clickHereLink.click();
		return this;
	}

	public String getNotificationMessage() {

		return(notificationMessage.getText());

	}
}


