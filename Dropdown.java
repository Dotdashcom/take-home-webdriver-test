package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;

public class Dropdown extends BaseClass{


	 
	
	public Dropdown() {
		super();	
	}
	
	
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(11) > a")).click();
	}
	
	
	@Test
	
	public void select () throws InterruptedException {
		 Select a = new Select(driver.findElement(By.id("dropdown")));
		a.selectByVisibleText("Option 1");
		Thread.sleep(2000);
		a.selectByIndex(2);
		Thread.sleep(2000);
	
		
		Boolean opt2 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)")).isSelected();
		Boolean opt1 = driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)")).isSelected();
		
		Assert.assertEquals(opt2, true);
		
	}

	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
	
}
