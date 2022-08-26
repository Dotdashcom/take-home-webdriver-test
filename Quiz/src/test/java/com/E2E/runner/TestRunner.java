package com.E2E.runner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.E2E.poms.userLoginPom;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/resources/features", glue="com/E2E/steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
public class TestRunner {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public static userLoginPom userLoginPom;
   
    @BeforeClass
    public static void setup(){
        

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        // wait = new WebDriverWait.WebDriverWait(driver);
        
        userLoginPom = new userLoginPom(driver);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}