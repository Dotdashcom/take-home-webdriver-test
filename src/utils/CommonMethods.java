package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods  {
    public static WebDriver driver;

    /**
     *
     * This method is launching the browser and navigate to the specific url
     */
    public static void setUp(String url){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     *
     * Closing browser
     */
    public static void tearDown(){
        if(driver !=null){
            driver.quit();
        }
    }

    }






