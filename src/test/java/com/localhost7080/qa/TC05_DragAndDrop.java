package com.localhost7080.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC05_DragAndDrop {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC05_DragAndDrop_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement a = driver.findElement(By.xpath("//header[contains(text(),'A')]"));
		WebElement b = driver.findElement(By.xpath("//header[contains(text(),'B')]"));
//		WebElement b = driver.findElement(By.xpath("//div[@id='column-b']"));

		// Not work :c
		Actions act = new Actions(driver);
//		act.dragAndDrop(b, a).build().perform();
		Action dragAndDrop = act.clickAndHold(a).moveToElement(b).release(b).build();
		dragAndDrop.perform();
	}

	@AfterTest
	public void afterTest() {
//		driver.close();
	}

}
