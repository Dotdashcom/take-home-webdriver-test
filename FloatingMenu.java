package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class FloatingMenu extends BaseClass {

	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(19) > a")).click();
	}
	
	@Test
	
	public void menu() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		
		Actions abc = new Actions(driver);
		
		abc.moveToElement(driver.findElement(By.cssSelector("#menu > ul > li:nth-child(1) > a"))).build().perform();
		
		String item = driver.findElement(By.cssSelector("#menu > ul > li:nth-child(1) > a")).getText();
		
		Assert.assertEquals(item, "Home");
		
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}

}
