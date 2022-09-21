package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC07_DynamicContent {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC07_DynamicContent_Script() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dynamic_content");	
		
		//Get the first text
		String oldText = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		//Get the text after refresh
		String newText = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		
		//Validate text
		Assert.assertNotEquals(oldText, newText);
		driver.navigate().refresh();
		
		//Validate after second refresh
		String lastText = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
		Assert.assertNotEquals(newText, lastText);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
