package com.dotDash.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.DynamicContentPage;

public class DynamicContentPageTest extends TestBase {
	DynamicContentPage dynamicContentPage;

	public DynamicContentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		dynamicContentPage = new DynamicContentPage();
	}

	// Testing and asserting the value
	@Test(priority = 1)
	public void checked() {
		String testStr = dynamicContentPage.dynamicContent();
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]"));
		String actualStr = element.getText();
		Assert.assertNotEquals(testStr, actualStr);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
