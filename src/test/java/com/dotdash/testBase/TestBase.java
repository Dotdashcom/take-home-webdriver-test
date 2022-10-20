package com.dotdash.testBase;

import com.dotdash.utils.BrowserFactory;
import com.dotdash.utils.ConfigReader;
import com.dotdash.utils.Constants;
import com.dotdash.utils.PageInitializers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends PageInitializers {
    public static WebDriver driver;

    @BeforeMethod
    public void start(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                BrowserFactory.setDriver("chrome");
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver = BrowserFactory.getDriver();
        //driver.get(ConfigReader.getPropertyValue("internet-login"));
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        initializePageObjects();
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}
