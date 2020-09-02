package com.dotdash;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Denys on 9/1/20
 **/
public class BaseAPI {

    public static String baseURL = "http://localhost:7080/";

    public WebDriver getLocalDriver(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String home = System.getProperty("user.home");

    public static void sendKeys(WebElement element, String keys) {
        try {
            element.sendKeys(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void click(WebElement element) {
        try {
            implicitWait(3000);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getURL(WebElement element) {
        driver.getCurrentUrl();
    }

    public static void assertURLContains(String string) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        wait(1000);
        Assert.assertTrue(currentUrl.contains(string));
    }

    public static void assertElementContains(WebElement element, String string) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        String attributeTxt = element.getText();
        System.out.println("Element text: " + attributeTxt);
        Assert.assertTrue(attributeTxt.contains(string));
    }

    public static void rightClickElement(WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.contextClick(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void refreshThePage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dragNDrop(WebElement source, WebElement target) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(source, target).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertAlertContains(String string) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, string);
    }

    public static void selectFromDropdown(WebElement element, String option) {
        try {
            Select dropdown = new Select(element);
            dropdown.selectByValue(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollDownPx(String pxY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, " + pxY + ");");
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hoverOverElement(WebElement element) {
        implicitWait(3000);
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }
}