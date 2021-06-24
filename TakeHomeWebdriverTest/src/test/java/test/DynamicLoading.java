package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class DynamicLoading extends TestBase {

	@BeforeTest
	public void beforeDynamicControlsTest() {
		setup();
		driver.get("http://localhost:7080/dynamic_loading/2");
			
	}

	@AfterTest
	public void afterDynamicControlsTest() {
		teardown();
	}
	
	@Test
	public void dynamicLoading() {
	//driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[contains(text(),'Hello World!')]")));
	Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");
	
	driver.navigate().back();
	driver.findElement(By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]")).click();
	WebElement startBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
	startBtn2.click();
	WebElement helloWorldMsg = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
	wait.until(ExpectedConditions.visibilityOf(helloWorldMsg));
	Assert.assertEquals(true, helloWorldMsg.isDisplayed());
	}
}
