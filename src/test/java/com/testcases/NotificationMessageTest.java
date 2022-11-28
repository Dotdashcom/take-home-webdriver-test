package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class NotificationMessageTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("NotificationMessageURL"));
	}

	@Test(priority = 2)
	public void notificationMsgTest() throws Exception {
		WebElement clickHere  = driver.findElement(By.linkText("Click here"));	
		clickHere.click();
		String actionMsg = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		Assert.assertEquals(actionMsg, "Action unsuccesful, please try again\n"+"×");
		WebElement clickHere1  = driver.findElement(By.linkText("Click here"));	
		clickHere1.click();
		Thread.sleep(2000);
		String actionMsg2 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
		System.out.println(actionMsg2);
//		Assert.assertEquals(actionMsg2, "Action successful\n"+"×");
		for(int i =0; i<=3; i++) {
			clickHere1.click();

		}
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();// terminates driver session and closes all windows
	}

}
