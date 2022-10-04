package com.dotdash.mkb.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BrowserUtils {

    private WebDriver driver = null;

    public void instantiateDriver(String targetBrowser) {

        if(targetBrowser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(targetBrowser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(targetBrowser.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("The browser, " + targetBrowser + ", is NOT supported.");
        }
        if(driver != null) {
            driver.manage().window().maximize();
        }
    }

    public void quitBrowser() {
        driver.quit();
    }

    public <T> T open(String pageFullURL, Class<T> pageClassProxy) {
        driver.get(pageFullURL);

        // Before creating a PageObject, Wait until page is loaded.
        WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wdWait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete"));

        return PageFactory.initElements(driver, pageClassProxy);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void scrollByPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)", "");
    }

    public void switchToIframe(String id) {
        driver.switchTo().frame(id);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
