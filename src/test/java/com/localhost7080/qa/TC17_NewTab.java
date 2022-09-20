package com.localhost7080.qa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC17_NewTab {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/windows");
		
		//Click on the link
		driver.findElement(By.linkText("Click Here")).click();	
		
		//Declare a list of Tabs, switch to new tab and their current URL to compare
		List<String> newTab = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7080/windows/new");
		
		driver.quit();

	}

}
