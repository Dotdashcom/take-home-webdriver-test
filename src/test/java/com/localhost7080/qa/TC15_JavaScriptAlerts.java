package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC15_JavaScriptAlerts {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC15_JavaScriptAlerts_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/javascript_alerts");

		// JS Alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		driver.switchTo().alert().getText();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
		driver.switchTo().alert().accept();

		// JS Confirm
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		driver.switchTo().alert().getText();
		Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
		driver.switchTo().alert().accept();

		// JS Prompt
		String text = "Hola Mundo";
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
		String[] text2 = driver.findElement(By.id("result")).getText().split(":");
		Assert.assertEquals(text2[1].trim(), text);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
