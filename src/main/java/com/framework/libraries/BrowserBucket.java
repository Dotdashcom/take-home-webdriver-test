package com.framework.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


public class BrowserBucket{
    private WebDriver driver;
    private ChromeCapabilities chromeCapabilities;
    public static String environment;

    public BrowserBucket(){
        String browserName = null;
        if(System.getProperty("browser") != null ){
            browserName= System.getProperty("browser").toUpperCase();
        } else {
            browserName = "CHROME";
        }
        switch(browserName) {
            case "CHROME":
                chromeCapabilities=new ChromeCapabilities();
                driver= new ChromeDriver(chromeCapabilities.chromeOptions);
                openEnvironmentInBrowser();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().forceDownload().useBetaVersions().setup();
                driver=new FirefoxDriver();
                openEnvironmentInBrowser();
            default:
                chromeCapabilities=new ChromeCapabilities();
                driver= new ChromeDriver(chromeCapabilities.chromeOptions);
                openEnvironmentInBrowser();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void openEnvironmentInBrowser(){
        setEnv();
        driver.manage().window().maximize();
        driver.get(environment);
    }

    public void setEnv(){
        Properties prop=new Properties();
        try {
            prop.load(new InputStreamReader(getClass().getResourceAsStream(File.separator+"environment.properties"), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        environment= prop.getProperty("internet-login");
    }


}
