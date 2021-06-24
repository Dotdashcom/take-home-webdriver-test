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

public class DynamicControls extends TestBase {
	
	@BeforeTest
	public void beforeDynamicControlsTest() {
		setup();
		driver.get("http://localhost:7080/dynamic_controls");
	}

	@AfterTest
	public void afterDynamicControlsTest() {
		teardown();
	}
	
	@Test
	public void DynamicControlsTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement removeBtn = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeBtn.click();
		WebElement goneMsg = driver.findElement(By.xpath("//p[contains(text(),'gone!')]"));
		wait.until(ExpectedConditions.visibilityOf(goneMsg));
		Assert.assertEquals(goneMsg.getText(), "It's gone!");
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		Assert.assertEquals(true, checkBox.isDisplayed());
		
		WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableBtn.click();
		WebElement enabledMsg = driver.findElement(By.xpath("//p[contains(text(),'enabled!')]"));
		wait.until(ExpectedConditions.visibilityOf(enableBtn));
		Assert.assertEquals(true, enabledMsg.isDisplayed());
		
		WebElement disableBtn = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
		disableBtn.click();
		WebElement disabledMsg = driver.findElement(By.xpath("//p[@id='message'][contains(text(),'disabled!')]"));
		wait.until(ExpectedConditions.visibilityOf(disabledMsg));
		Assert.assertEquals(true, disabledMsg.isDisplayed());
	}

}
