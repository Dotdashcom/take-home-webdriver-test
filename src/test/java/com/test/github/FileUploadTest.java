package com.test.github;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class FileUploadTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/upload");
    }
    @Test
    public void fileUploadTest() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	  WebElement uploadElement = driver.findElement(By.id("file-upload"));
          String filepath=System.getProperty("user.dir")+"/Test.rtf";
          // enter the file path onto the file-selection input field
          uploadElement.sendKeys(filepath);
      
          driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();

          String getText= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
          Assert.assertTrue(getText.contains("File Uploaded!"),"Text is not present");
    
        //*[@id="uploaded-files"]
        //*[@id="content"]/div/h3
}
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

