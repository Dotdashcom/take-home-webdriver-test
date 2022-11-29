package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC11_FileUpload {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC11_FileUpload_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/upload");

		// File to upload
		WebElement fileUpload = driver.findElement(By.id("file-upload"));
		// Select Path and click Upload button
		fileUpload.sendKeys("C:/Users/JM00895463/Downloads/Info.txt");
		driver.findElement(By.cssSelector("input[class='button']")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
