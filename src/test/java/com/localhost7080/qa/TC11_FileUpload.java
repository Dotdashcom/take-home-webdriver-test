package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC11_FileUpload {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/upload");
		
		//File to upload
		WebElement fileUpload = driver.findElement(By.id("file-upload"));
		//Select Path and click Upload button
		fileUpload.sendKeys("C:/Users/JM00895463/Downloads/Info.txt");
		driver.findElement(By.cssSelector("input[class='button']")).click();
		
		driver.close();
		
	}

}
