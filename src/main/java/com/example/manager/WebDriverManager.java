package com.example.manager;

import com.example.utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;
    private static String driverType;
    private static String environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    static ReadProperties readProperties = new ReadProperties();

    public WebDriverManager(){
        driverType = FileReadManager.getInstance().getReadProperties().getBrowser();
        environmentType = FileReadManager.getInstance().getReadProperties().getEnv();
    }

    public static WebDriver getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        driverType = FileReadManager.getInstance().getReadProperties().getBrowser();
        switch (driverType.toUpperCase()) {
            case "CHROME":
                System.setProperty(CHROME_DRIVER_PROPERTY, readProperties.getDriverPath() + "chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    public void closeDriver(){
        //driver.close();
        driver.quit();
    }
}
