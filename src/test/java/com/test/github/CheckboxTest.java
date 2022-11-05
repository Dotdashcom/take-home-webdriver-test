package com.test.github;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxTest {
	 
		WebDriver driver;
	    @BeforeTest
	    public void setup() {
	        // Set up the wWebDriverManager for chrome driver
	        WebDriverManager.chromedriver().setup();
	        // Create the driver object
	        driver = new ChromeDriver();
	        driver.get("http://localhost:7080/checkboxes");
	    }
	    @Test
	    public void checkboxTest() {
	    	
	    	 WebDriverWait wait = new WebDriverWait(driver,30);
	         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='checkbox']")));
	    	
	         List<WebElement> mycheckBox = driver.findElements(By.xpath("//*[@type='checkbox']"));
	    	 for(int i=0;i<mycheckBox.size();i++){
	    	    System.out.println("attribut value Selected of Check-box is : " + mycheckBox .get(i).getAttribute("selected"));
	    	    // if Check-box is selected then value of selected attribute is True else null
	    	    if( mycheckBox.get(i).getAttribute("selected") != null){
	    	        
	    	        mycheckBox .get(i).click();
	    	    }
	    	}

	    }
	    
	    @AfterTest
	    public void teardown() {
	       // Close the driver
	        driver.quit();
	    }
}
