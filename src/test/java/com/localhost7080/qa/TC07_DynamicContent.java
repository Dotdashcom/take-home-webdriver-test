package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC07_DynamicContent {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		
		driver.close();

	}

}
