package com.test.github;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dropdown");
    }
    @Test
    public void dropDownTest() {
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dropdown']")));
       
    	
    	Select oSel = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
       			//Selecting multiple values by value
    				
    	if(oSel.isMultiple()){
    		oSel.selectByValue("1");
    		oSel.selectByValue("2");
    	}else
    	{
    		System.out.println("This dropdown is not multiple");
    		oSel.selectByValue("2");
    	}	
    				List<WebElement> selectedOptions = oSel.getAllSelectedOptions();
        			for(WebElement options: selectedOptions)
        	            System.out.println(options.getText());

    			}
    
    
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

