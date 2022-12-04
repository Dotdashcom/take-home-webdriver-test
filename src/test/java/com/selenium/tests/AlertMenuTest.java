package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertMenuTest extends TestBase {

	@Test
	public void alertMenu() {

		driver.get("http://localhost:7080/context_menu");

		WebElement area = driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		actions.contextClick(area).perform();
		String msg = driver.switchTo().alert().getText();

		Assert.assertEquals(msg, "You selected a context menu");

	}
}