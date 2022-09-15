package com.dotdash.core.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class WebDriverBuilder {
    public WebDriver driver;

    public WebDriverBuilder(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }catch (Exception exp){
            System.out.println("Error cause: " + exp.getCause());
            System.out.println("Error message: " + exp.getMessage());
        }
    }
}
