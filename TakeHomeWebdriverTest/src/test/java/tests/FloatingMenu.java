package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class FloatingMenu extends TestBase {
	
	@BeforeTest
	public void beforeFloatingMenuTest() {
		setup();
		driver.get("http://localhost:7080/floating_menu");
	}

	@AfterTest
	public void afterFloatingMenuTest() {
		teardown();
	}
	
	@Test
	public void floatingMenuTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Floating Menu')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement floatingMenu = driver.findElement(By.id("menu"));
		Assert.assertEquals(true, floatingMenu.isDisplayed());
	}
}
