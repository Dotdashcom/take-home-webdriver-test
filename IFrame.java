package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class IFrame extends BaseClass {
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(22) > a")).click();
	}
	
	@Test
	
	public void frame() {
		
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > a")).click();
		
		WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
		
		driver.switchTo().frame(iframe);
		
		WebElement body = driver.findElement(By.cssSelector("#tinymce"));
		
		body.clear();
		
		body.sendKeys("Hello");
		
		String actual = body.getText();
		
		Assert.assertEquals(actual, "Hello");
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}


}
