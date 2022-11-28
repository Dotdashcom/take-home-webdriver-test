package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;

public class MoiseHoverTest extends TestBase {
	@BeforeTest
	public void testUrl() {
		initialization();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("mouseHoverURL"));
	}

	@Test(priority = 2)
	public void mouseHoverTestTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).build().perform();
		String username = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
		Assert.assertEquals(username, "name: user1", "Dose not match");	//Assert
		

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
