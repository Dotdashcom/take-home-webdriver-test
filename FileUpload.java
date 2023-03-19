package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class FileUpload extends BaseClass {

	@BeforeMethod
	
	public void openUrl() {
		initiate();
		driver.findElement(By.cssSelector("#content > ul > li:nth-child(18) > a")).click();
	}
	
	
	@Test
	
	public void upload() {
		
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Service 1\\eclipse-workspace\\Webdriver\\test.docx");
		driver.findElement(By.id("file-submit")).click();		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		String actual = driver.findElement(By.cssSelector("#content > div > h3")).getText();
		Assert.assertEquals(actual, "File Uploaded!");
	
	}
	
	
	@AfterSuite
	
	public void close() {
		driver.quit();
	}

}
