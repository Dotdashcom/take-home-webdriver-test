package com.test.github;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
       ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
		options.setExperimentalOption("prefs", prefs);
		
		
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver(options);
        driver.get("http://localhost:7080/download");
    }
    @Test
    public void fileDownloadTest() throws IOException {
    	 String tmpdir = System.getProperty("java.io.tmpdir");
         System.out.println("Temp file path: " + tmpdir);
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         String filename=driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).getText();
    	 driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();
    	 File f = new File(tmpdir+filename); 
    	 Assert.assertTrue(f.exists());    
}
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

