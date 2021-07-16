package com.dotdash;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    protected WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe"); //windows
        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
