package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;

public class DragDrop extends BaseClass {

	
	 
	
	public DragDrop() {
		super();	
	}
	
	
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(10) > a")).click();
	}
	
	
	@Test
	
	public void dnd () throws InterruptedException {
		 Actions a = new Actions(driver);
		 WebElement A = driver.findElement(By.cssSelector("#column-a"));
		 WebElement B = driver.findElement(By.cssSelector("#column-b"));
		 
		 
		 Thread.sleep(2000);

		 a.dragAndDrop(A, B).build().perform();
		 String txt = driver.findElement(By.id("column-a")).getText();
			Assert.assertEquals(txt, "B");
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
	
}
