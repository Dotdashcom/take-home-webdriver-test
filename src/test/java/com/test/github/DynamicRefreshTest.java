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

public class DynamicRefreshTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_controls");
    }
    @Test
    public void dynamicRefreshTestWithRemoveCheckbox() {
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
         // explicit wait - to wait for the compose button to be click-able
         WebDriverWait wait = new WebDriverWait(driver,30);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
         System.out.println("Checkbox is removed");
         String getText= driver.findElement(By.id("message")).getText();
         Assert.assertTrue(getText.contains("It's gone!"),"Checkbox is not removed");
   
         driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
         WebDriverWait waitCheckBoxispresent = new WebDriverWait(driver,30);
         waitCheckBoxispresent.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/div[1]")));
         System.out.println("Checkbox is added");
         
         
    }
    
    @Test
    public void dynamicRefreshTestWithEnableButton() {

          driver.findElement(By.xpath("//*[contains(@id,\"input-example\")]/button")).click();

          
          WebDriverWait wait = new WebDriverWait(driver,30);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
          
          String enabledtext=driver.findElement(By.id("message")).getText();
          System.out.println(enabledtext);
          Assert.assertTrue(enabledtext.contains("It's enabled!"), "Not enabled");
          
          boolean textField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).isEnabled();
          Assert.assertEquals(textField,true);
         driver.findElement(By.xpath("//*[contains(@id,\"input-example\")]/button")).click();

          
          WebDriverWait wait1 = new WebDriverWait(driver,30);
          wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
          
          String DisabledtextField=driver.findElement(By.id("message")).getText();
          System.out.println(DisabledtextField);
          Assert.assertTrue(DisabledtextField.contains("It's disabled!"), "Not disabled");
          
    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

