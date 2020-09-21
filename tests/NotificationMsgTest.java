package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;

public class NotificationMsgTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/notification_message_rendered");
	}
	// Test clicks on the Click Here link a multiple times.
	// Test asserts that one of the “Action Successful”, “Action unsuccessful,
	// please try again” and “Action Unsuccessful” messages show on click.

	@Test
	public void Notification() {
		Actions action = new Actions(driver);
		WebElement clickHereLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		WebElement message = driver.findElement(By.xpath("//*[@id=\"flash\"]"));

		action.contextClick(clickHereLink).build().perform();
		String result = message.getText();
		String successMSG = message.getText();

		Assert.assertEquals(result, "Action Successful");
		Assert.assertEquals(result, "Action unsuccessful, please try again");
		Assert.assertEquals(result, "Action Unsuccessful");

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}
