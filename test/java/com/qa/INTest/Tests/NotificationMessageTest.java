package com.qa.INTest.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessageTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void vldNotificationMessageTest() {

		driver.get("http://localhost:7080/notification_message_rendered");

		driver.findElement(By.linkText("Click here")).click();
		String firstClickMessage = driver.findElement(By.id("flash")).getText();
		System.out.println(firstClickMessage);

		driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
		String secondClickMessage = driver.findElement(By.id("flash")).getText();
		System.out.println(secondClickMessage);

		driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
		String thirdClickMessage = driver.findElement(By.id("flash")).getText();
		System.out.println(thirdClickMessage);

	
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
