package com.localhost7080.qa;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC18_NotificationMessage {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC18_NotificationMessage_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/notification_message_rendered");

		// Expected messages
		String[] msgExpected = { "Action successful", "Action unsuccesful, please try again" };

		for (int i = 0; i <= 10; i++) {

			// Click on the link
			driver.findElement(By.linkText("Click here")).click();

			// Get the text message, delete the "x", and safe as an array list
			String[] msg = driver.findElement(By.xpath("//div[@class='flash notice']")).getText().split("\n");
			List msgList = Arrays.asList(msg[0].trim());

			// Search whether the expected messages are inside the array list and assert it.
			if ((msgList.contains(msgExpected[0]) || (msgList.contains(msgExpected[1])))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
