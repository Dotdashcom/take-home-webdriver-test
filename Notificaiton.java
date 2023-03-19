package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Notificaiton extends BaseClass {

	SoftAssert sa = new SoftAssert();
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(35) > a")).click();
	}
	
	@Test
	
	public void notification() {
		driver.findElement(By.cssSelector("#content > div > p > a")).click();
		
		String[] message = {"Action successful", "Action unsuccesful, please try again"};
		
		for (int i = 1; i<=2; i++) {
			
			driver.findElement(By.cssSelector("#content > div > p > a")).click();
			String actual = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
			System.out.println(actual);
			sa.assertEquals(actual, message);
		}
		
	}
	@AfterMethod
	
	public void close() {
		driver.quit();
	}
}
