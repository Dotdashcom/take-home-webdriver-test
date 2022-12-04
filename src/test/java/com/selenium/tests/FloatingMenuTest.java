package com.selenium.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends TestBase {

	@Test
	public void floatingMenu() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("http://localhost:7080/floating_menu");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-footer")));

		List<WebElement> menu = new ArrayList<>();
		menu = driver.findElements(By.cssSelector("#menu li")).stream()
				.filter(e -> e.isDisplayed())
				.collect(Collectors.toList());

		Assert.assertEquals(menu.size(), 4);

	}
}