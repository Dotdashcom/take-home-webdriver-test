package com.testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class NewTabTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("newTabURL"));
	}

	@Test(priority = 2)
	public void newTabTest() throws Exception {
		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
		driver.switchTo().newWindow(WindowType.TAB);
		
		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(2));
		System.out.println("Page title of new tab: " + driver.getTitle());
		String newTabTitle = driver.findElement(By.xpath("/html/body/div/h3")).getText();
		Assert.assertEquals(newTabTitle, "New Window","Home page title not matched");
		// switching to parent window
		driver.switchTo().window(newTb.get(0));
		System.out.println("Page title of parent window: " + driver.getTitle());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
