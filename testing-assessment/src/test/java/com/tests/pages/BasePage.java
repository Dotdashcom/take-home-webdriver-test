package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This abstract class provides commonly used methods or classes throughout the project and can't be instantiated
 * tightly coupled
 */
public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverTest.getDriver(),this);
    }

    Actions actions = new Actions(DriverTest.getDriver());
    static WebDriverWait wait = new WebDriverWait(DriverTest.getDriver(), Duration.ofSeconds(120));
    static JavascriptExecutor js = (JavascriptExecutor) DriverTest.getDriver();

    public static void waitForVisibilityOf(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void assertTheTextMessage(Object className,WebElement element, String textMessage){
          String actualMessage = element.getText();
        Assert.assertTrue(actualMessage.contains(textMessage));
        System.out.println("-> " + className + " text message is: " + actualMessage);
    }
}
