package com.localhost7080.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC06_DropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/dropdown");
		
		//Create a select dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown"));
		Select dropdown = new Select(staticDropdown);
		
		//Select and validate option 1
		dropdown.selectByVisibleText("Option 1");
		String option = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(option,"Option 1");
		
		//Select and validate option 2
		dropdown.selectByVisibleText("Option 2");
		String option2 = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(option2,"Option 2");
		
		driver.close();	

	}

}
