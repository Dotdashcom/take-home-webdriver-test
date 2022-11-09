package com.dotdash.selenium.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class WebDriverBuilder {
    public WebDriver driver;

    public WebDriverBuilder(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }catch (Exception exception){
            System.out.println("Error cause: " + exception.getCause());
            System.out.println("Error message: " + exception.getMessage());
        }
    }
}
