package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class FloatingMenuTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/floating_menu");
	}

	@Test
	public void ScrollPage() {
		// Test scrolls the page.
		// Test asserts that the floating menu is still displayed.

		WebElement floatingMenu = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Assert.assertTrue(floatingMenu.isDisplayed());

	}

	@AfterMethod

	public void aftermethod() {

		// driver.quit();

	}
}
