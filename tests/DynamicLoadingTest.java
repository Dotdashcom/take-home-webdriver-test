package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class DynamicLoadingTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
	}
	// Test clicks the start button and uses explicit wait.
	// Test asserts that “Hello World!” text is displayed.

	@Test
	public void dynamicLoad() {

		WebElement startButton = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
		WebElement helloWorldDisplay = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));

		DriverUtility.clickonElement(startButton);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(helloWorldDisplay));
		Assert.assertEquals(helloWorldDisplay.getText(),"Hello World!");

	}

}