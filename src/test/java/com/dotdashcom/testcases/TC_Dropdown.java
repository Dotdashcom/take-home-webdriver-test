package com.dotdashcom.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Dropdown {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/dropdown");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void clickDropDown() {
		Select el = new Select(driver.findElement(By.id("dropdown")));
		
		List<WebElement> options = el.getOptions();
		for(int i=1; i<options.size();i++) {		 
			el.selectByIndex(i);
			String selectedOption = el.getFirstSelectedOption().getText();
			Assert.assertEquals(selectedOption, "Option "+ i);
		}		
	}
}
