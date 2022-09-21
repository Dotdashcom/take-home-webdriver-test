package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC12_FloatingMenu {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/floating_menu");
		
		//Verify whether the element is present before scroll down
		Boolean x = driver.findElement(By.id("menu")).isDisplayed();
		//scroll down
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,2000)");
		//Verify whether the element still present
		Boolean y = driver.findElement(By.id("menu")).isDisplayed();
		Assert.assertEquals(x, y);
		
		driver.close();

	}

}
