package com.selenium.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewTabTest extends TestBase {

	@Test
	public void openNewTabTest() {
		driver.get("http://localhost:7080/windows");

		WebElement link = driver.findElement(By.linkText("Click Here"));
		link.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		tabs.stream().filter(s -> !s.contentEquals(currentWindow)).forEach((s) -> {
			driver.switchTo().window(s);
		});
		String text = driver.findElement(By.cssSelector("h3")).getText();
		Assert.assertEquals(text, "New Window");

	}
}