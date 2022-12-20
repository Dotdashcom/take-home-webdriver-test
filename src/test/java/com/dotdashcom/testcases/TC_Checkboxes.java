package com.dotdashcom.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dotdashcom.utilities.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.Select;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Checkboxes {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/checkboxes");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void clickCheckboxes() {
		List<WebElement> ch = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i =0; i<ch.size();i++) {
			if(!ch.get(i).isSelected()) {
				ch.get(i).click();
				Assert.assertTrue(ch.get(i).isSelected());
			}else {
				ch.get(i).click();
				Assert.assertFalse(ch.get(i).isSelected());
			}
		}
	}	
}