package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class NotificationPage extends PageObjectBase {

	public NotificationPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public NotificationPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public NotificationPage clickLink() {

		WebElement link = this.getDriver().findElement(By.xpath("//p/a"));
		link.click();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/notification_message_rendered";
	}

}
