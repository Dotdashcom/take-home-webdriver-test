package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC06_DropDown {

	WebDriver driver;
	Base_DDM base;

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC06_DropDown_Script() {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dropdown");

		// Create a select dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown"));
		Select dropdown = new Select(staticDropdown);

		// Select and validate option 1
		dropdown.selectByVisibleText("Option 1");
		String option = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Option 1");

		// Select and validate option 2
		dropdown.selectByVisibleText("Option 2");
		String option2 = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(option2, "Option 2");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
