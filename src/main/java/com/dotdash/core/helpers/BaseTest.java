package com.dotdash.core.helpers;

import com.dotdash.core.browser.WebDriverBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        try {
            WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
            driver = webDriverBuilder.driver;
        } catch (Exception exp) {
            System.out.println("Error cause: " + exp.getCause());
            System.out.println("Error message: " + exp.getMessage());
        }
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
