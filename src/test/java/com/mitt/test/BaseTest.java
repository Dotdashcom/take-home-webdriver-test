package com.mitt.test;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    @BeforeTest
    public void beforeSuite() {
        System.out.println("Opening Browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    @AfterClass
    public void tearDown() {
        if(this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }
}

