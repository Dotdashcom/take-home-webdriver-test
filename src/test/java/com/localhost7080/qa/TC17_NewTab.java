package com.localhost7080.qa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC17_NewTab {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC17_NewTab_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/windows");

		// Click on the link
		driver.findElement(By.linkText("Click Here")).click();

		// Declare a list of Tabs, switch to new tab and their current URL to compare
		List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7080/windows/new");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
