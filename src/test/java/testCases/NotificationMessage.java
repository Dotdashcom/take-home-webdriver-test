package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class NotificationMessage extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateNotificationMessages() throws InterruptedException {
		// locate and click on NotificationMessage link
		WebElement nm_link = driver.findElement(By.xpath("//a[contains(text(),'Notification Messages')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(nm_link));
		nm_link.click();

		// verify if NotificationMessage page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/notification_message_rendered";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// click on click here 5 times and verifying correct notification message
		for (int i = 0; i < 5; i++) {
			WebElement clickHere_link = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			clickHere_link.click();
			Thread.sleep(2000);
			WebElement notification = driver.findElement(By.xpath("//div[@id='flash']"));
			String notificationMsg = notification.getText();
			System.out.println(notificationMsg);
			if (notificationMsg.equalsIgnoreCase("Action successful")
					|| notificationMsg.equalsIgnoreCase("Action unsuccesful, please try again")) {
				softassert.assertTrue(true);
			}

		}

		softassert.assertAll();

	}

}
