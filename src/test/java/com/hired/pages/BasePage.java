package com.hired.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class BasePage {
    public Properties prop;
    WebDriver driver;

    public WebDriver getDriver() {

        try {
            prop = new Properties();
        FileInputStream file= new FileInputStream("configuration.properties");
       prop.load(file);
            file.close();
        }  catch(IOException e){
        e.printStackTrace();
    }

        String browserName= prop.getProperty("browser");

        switch(browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

        }
        return driver;
    }

    }



