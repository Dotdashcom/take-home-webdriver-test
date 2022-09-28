package com.dotdash.mkb.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BrowserUtils {

    private static WebDriver driver = null;

    public static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public static <T> T open(String pageFullURL, Class<T> pageClassProxy) {
        driver.get(pageFullURL);

        // Before creating a PageObject, Wait until page is loaded.
        WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdWait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete"));

        return PageFactory.initElements(driver, pageClassProxy);
    }

    public static void refresh() {
        driver.navigate().refresh();
    }

    public static void scrollByPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)", "");
    }

    public static void switchToIframe(String id) {
        driver.switchTo().frame(id);
    }

    public static void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
