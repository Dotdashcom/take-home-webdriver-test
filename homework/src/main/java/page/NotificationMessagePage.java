package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NotificationMessagePage {

	WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Notification Messages')]")
	WebElement NOTIFICATION_MENU_ELEMENT;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Click here')]")
	WebElement CLICK_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"flash\"]")
	WebElement FLASHMESSAGE_ELEMENT;

	public void notificationMenu() {
		NOTIFICATION_MENU_ELEMENT.click();
	}

	public void clickElement() throws InterruptedException {

		boolean flag = true;
		Thread.sleep(2000);
		while (flag == true) {
			CLICK_ELEMENT.click();
			System.out.println(FLASHMESSAGE_ELEMENT.getText());
			Thread.sleep(2000);
			if (FLASHMESSAGE_ELEMENT.getText().contains("successful")) {
				flag = false;
			}
		}
	}

}
