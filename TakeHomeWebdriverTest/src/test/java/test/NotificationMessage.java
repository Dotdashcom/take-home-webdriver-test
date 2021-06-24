package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class NotificationMessage extends TestBase {
	@BeforeTest
	public void beforeNotificationMsgTest() {
		setup();
		driver.get("http://localhost:7080/notification_message_rendered");
	}

	@AfterTest
	public void afterNotificationMsgTest() {
		teardown();
	}
	
	@Test
	public void notificationMsgTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Notification Messages')]")).click();
		
		for (int i = 0; i < 20; i++) {
			WebElement notificationMsg = driver.findElement(By.xpath("//div[@id='flash']"));
			String notificationMsgTxt = notificationMsg.getText();
			WebDriverWait wait = new WebDriverWait(driver, 6);
			WebElement clickHereMsgLoader = driver.findElement(By.linkText("Click here"));
			 clickHereMsgLoader.click();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
			 
			 if(notificationMsgTxt.contains("Action successful") || notificationMsgTxt.contains("Action unsuccesful")) {
				 Assert.assertTrue(true);
			 }
				 else {
					 Assert.assertTrue(false);
				 }
		}
	}
}
				
			 