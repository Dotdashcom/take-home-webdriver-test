package com.qa.INTest.Tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenNewTabTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void vldOpenInNewTabTest() throws InterruptedException {
		driver.get("http://localhost:7080/windows");
		driver.findElement(By.linkText("Click Here")).click();

		Thread.sleep(2000);

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());

		Iterator<String> itr = allWindows.iterator();

		String parentWindow = itr.next();
		String childWindow = itr.next();
		System.out.println(parentWindow);
		System.out.println(childWindow);

		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "New Window");

		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
