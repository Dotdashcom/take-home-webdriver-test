package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class TC15_JavaScriptAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/javascript_alerts");	
		
		//JS Alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		driver.switchTo().alert().getText();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
		driver.switchTo().alert().accept();
		
		//JS Confirm
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().getText();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
		driver.switchTo().alert().accept();
		
		//JS Prompt
		String text = "Hola Mundo";
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
		String[] text2 = driver.findElement(By.id("result")).getText().split(":");
		Assert.assertEquals(text2[1].trim(), text);
		
		driver.close();
		
	}

}
