package dotdash.automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePageObject {

    protected WebDriverWait wait;

    protected WebDriver driver;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }

}
