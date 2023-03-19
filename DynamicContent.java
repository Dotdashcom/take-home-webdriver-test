package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;

public class DynamicContent extends BaseClass {
	 
	String actual;
	public DynamicContent() {
		super();	
	}
	

	@BeforeSuite
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(12) > a")).click();
	}
	
	
	@Test
	
	public void text() throws InterruptedException{
		actual = driver.findElement(By.cssSelector("#content > div:nth-child(1) > div.large-10.columns")).getText();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String txt = driver.findElement(By.cssSelector("#content > div:nth-child(1) > div.large-10.columns")).getText();
		Assert.assertEquals(txt, txt);
	}
	
	
	
	
	@AfterSuite
	
	public void close() {
		driver.quit();
	}
	
}
