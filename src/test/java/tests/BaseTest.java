package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {
    protected static boolean tearDownBrowser;
    protected static String baseUrl;
    protected static WebDriver webDriver;
    protected static Actions actions;

    protected void dragAndDrop(WebElement from, WebElement to) {
        actions.dragAndDrop(from, to).build().perform();
    }

    protected void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    protected Alert getAlert() throws NoAlertPresentException {
        return webDriver.switchTo().alert();
    }

    @BeforeAll
    static void setup() {
        webDriver = DriverManager.getWebDriver();
        actions = new Actions(webDriver);
        baseUrl = ConfigReader.getProperty("baseUrl");
        tearDownBrowser = ConfigReader.getPropertyAsBoolean("closeBrowser");
    }

    @AfterAll
    static void tearDown() {
        if (tearDownBrowser) {
            webDriver.quit();
        }
    }
}
