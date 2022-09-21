package com.localhost7080.qa;

import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC04_ContextMenu {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeClass() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC04_ContextMenu_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/context_menu");

		// Do a right click on ContextMenu
		Actions actions = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.id("hot-spot"));
		actions.contextClick(contextMenu).perform();

		// Get the text of the alert, close it and do and Assertion.
		Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void afterClass() {
		driver.close();
	}

}
