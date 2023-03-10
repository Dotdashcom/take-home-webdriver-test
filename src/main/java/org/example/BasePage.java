package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    protected static WebDriver driver;

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(geturl());
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public String geturl(){
        String url = "http://localhost:7080";
        return url;
    }
    public void teardown(){
        driver.close();
        driver.quit();
    }

}
