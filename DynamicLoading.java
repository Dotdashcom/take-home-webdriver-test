package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class DynamicLoading extends BaseClass {
	
	public DynamicLoading() {
		super();
	}
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(14) > a")).click();
	}
	
	
	
	@Test
	
	public void element() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#content > div > a:nth-child(8)")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#start > button")).click();
		
		Thread.sleep(5000);
		
		String actual = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
		
		Assert.assertEquals(actual, "Hello World!");
		
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}

}
