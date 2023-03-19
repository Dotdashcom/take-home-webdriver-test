package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;

public class DynamicControls extends BaseClass {

	public DynamicControls() {
		super();	
	}
	

	@BeforeSuite
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(13) > a")).click();
	}
	
	
	@Test (priority =1 )
	
	public void remove() throws InterruptedException{
		driver.findElement(By.cssSelector("#checkbox-example > button")).click();
		Thread.sleep(5000);
		String txt = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(txt, "It's gone!");
	}
	
	
	@Test (dependsOnMethods = {"remove"}, priority = 2)
	
	public void add() throws InterruptedException{
		driver.findElement(By.cssSelector("#checkbox-example > button")).click();
		Thread.sleep(5000);
		WebElement cb = driver.findElement(By.id("checkbox"));
		Boolean b = cb.isDisplayed();
		Assert.assertEquals(b, true);
		
		String txt = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(txt, "It's back!");
	}
	
	
	@Test (priority =3)
	
	public void enable() throws InterruptedException {
		driver.findElement(By.cssSelector("#input-example > button")).click();
		Thread.sleep(5000);
		WebElement btn = driver.findElement(By.cssSelector("#input-example > button"));
		String actual = btn.getText();
		Assert.assertEquals(actual, "Disable");
		
		String txt = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(txt, "It's enabled!");
	}
	
	
	@Test (priority = 4)
	
	public void disable() throws InterruptedException {
		driver.findElement(By.cssSelector("#input-example > button")).click();
		Thread.sleep(5000);
		WebElement btn = driver.findElement(By.cssSelector("#input-example > button"));
		String actual = btn.getText();
		Assert.assertEquals(actual, "Enable");
		
		String txt = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(txt, "It's disabled!");
	
	}
	
	@AfterSuite
	
	public void close() {
		driver.quit();
	}
}
