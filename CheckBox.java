package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pom.PomLogin;

public class CheckBox extends BaseClass {


	 Boolean cb1, cb2;
	
	public CheckBox() {
		super();	
	}
	
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(6) > a")).click();
	}
	
	@Test
	
	public void checkBox() {
		
		WebElement c1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement c2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		
		cb1 = c1.isSelected();
		cb2 = c2.isSelected();
		
		
		if(!c1.isSelected()) {
			Assert.assertEquals(false, cb1);
			c1.click();
		}
		
		else if (!c2.isSelected()) {
			Assert.assertEquals(false, cb2);
			c2.click();
		}
		
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}

	
	
}
