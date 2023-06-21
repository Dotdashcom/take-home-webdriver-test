package com.example.navigation;

import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.logging.Logger;


public class WebDriverJavaUtil {
    Logger log = Logger.getLogger(WebDriverJavaUtil.class.getName());
    private static ReadProperties readProperties;
    WebDriver driver;

    public WebDriverJavaUtil(WebDriver driver){
        this.driver = driver;
    }
    public String getWebElementText(By by){
        return getWebElement(by).getText()
                .replace("\n","")
                .replace("\t","")
                .trim();
    }

    public WebElement getWebElement(By by){
        waitForWebElementToAppear(by);
        return driver.findElement(by);
    }

    public void waitForWebElementToAppear(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
    }

    public void clckOnWebElement(By by){
        waitForMilliSeconds(1000L);
        try {
            getWebElement(by).click();
        }catch (NoSuchElementException noSuchElementException){
            log.info("Can't click element.");
        }
    }

    public void waitForMilliSeconds(long milliSeconds) {
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            log.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void enterStringInputBox(By by, String inputString){
        getWebElement(by).clear();
        waitForMilliSeconds(1000);
        getWebElement(by).sendKeys(inputString);
    }

}
