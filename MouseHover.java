package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class MouseHover extends BaseClass {
	
	SoftAssert sa = new SoftAssert();
	
	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(25) > a")).click();
	}
	
	@Test
	
	public void hover() {
		
		Actions abc = new Actions(driver);
	
		abc.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).build().perform();
		String user1 = driver.findElement(By.className("figcaption")).getText();
		System.out.println(user1);
		sa.assertEquals(user1, "name: user1 View profile");
		
		abc.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"))).build().perform();
		String user2 = driver.findElement(By.className("figcaption")).getText();
		System.out.println(user2);
		sa.assertEquals(user2, "name: user2 View profile");
		
		abc.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"))).build().perform();
		String user3 = driver.findElement(By.className("figcaption")).getText();
		System.out.println(user3);
		sa.assertEquals(user3, "name: user3 View profile");
		
		
	}
	
	@AfterMethod
	
	public void close() {
		driver.quit();
	}

}
