package com.localhost7080.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC13_IframeTest {

	WebDriver driver;
	Base_DDM base;
	String text = "Hola Mundo";

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC13_IframeTest_Script() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/iframe");
		//Close pop-up
		driver.findElement(By.cssSelector("button[class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")).click();
		//Switch to frame, clear the input text, type, and assert the text
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys(text);
		Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), text);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
