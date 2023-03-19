package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class JSAlerts extends BaseClass{

	Alert al;
	SoftAssert sa = new SoftAssert();
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(29) > a")).click();
	}
	
	@Test
	
	public void alert() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		al = driver.switchTo().alert();
		String message = al.getText();
		sa.assertEquals(message, "I am a JS Alert");
	}
	
	@Test
	
	public void confirm() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		al = driver.switchTo().alert();
		String message = al.getText();
		sa.assertEquals(message, "I am a JS Confirm");
		al.accept();
		
	}
	
	@Test
	
	public void prompt() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		al = driver.switchTo().alert();		
		String message = al.getText();
		sa.assertEquals(message, "I am a JS prompt");
		
		String text = "Hello";
		al.sendKeys(text);
		al.accept();
		
		String actual = driver.findElement(By.id("result")).getText();
		sa.assertEquals(actual, text);
		
	
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
}
