package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.BaseClass;

public class Context extends BaseClass {

	
	 Boolean cb1, cb2;
	
	public Context() {
		super();	
	}
	
	
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(7) > a	")).click();
	}
	
	
	@Test
	
	public void context() {
		 Actions a = new Actions(driver);
	      a.moveToElement(driver.findElement(By.xpath("//*[@id=\"hot-spot\"]")));
	      a.contextClick().build().perform();
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      org.openqa.selenium.Alert al = driver.switchTo().alert();
			String message = al.getText();
			Assert.assertEquals(message, "You selected a context menu");
			al.accept();
	}
	

	@AfterMethod
	
	public void close() {
		driver.quit();
	}
}
