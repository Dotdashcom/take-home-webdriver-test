package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_CheckBoxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/checkboxes");
		
		//Verify first checkbox is checked
		Assert.assertFalse(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected());
		driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected());
		
		//Verify second checkbox is unchecked
		Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).isSelected());
		driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(3)")).isSelected());
		driver.close();
		
	}

}
