package com.localhost7080.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC14_MouseHover {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC14_MouseHover_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/hovers");

		// Find the quantity of images
		List<WebElement> imgs = driver.findElements(By.xpath("//img[@alt='User Avatar']"));

		// Do a mouse hover of all images and valid if their text are present
		for (int i = 1; i <= imgs.size(); i++) {
			WebElement items = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[" + i + "]"));
			Actions action = new Actions(driver);
			action.moveToElement(items).perform();
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='figcaption'])[" + i + "]")).isDisplayed(),
					true);
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
