package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Iframe extends TestBase {
	
	@BeforeTest
	public void beforeIframeTest() {
		setup();
		driver.get("http://localhost:7080/iframe");
	}

	@AfterTest
	public void afterIframeTest() {
		teardown();
	}
	
	@Test
	public void iframeTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'Frames')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
		driver.switchTo().frame("mce_0_ifr"); //Switching to iframe using ID
		WebElement contentBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
		Actions act = new Actions(driver);
		act.moveToElement(contentBox).click().build().perform();
		contentBox.sendKeys(Keys.CONTROL,"a");
		contentBox.sendKeys(Keys.BACK_SPACE);
		contentBox.sendKeys("test123");
		String actualTypedText = contentBox.getText();
		Assert.assertEquals(actualTypedText, "test123");
	}

}
