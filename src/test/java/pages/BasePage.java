package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriverWait webDriverWait;
    protected static int defaultTimeOut;

    protected void waitForElementToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public abstract void assertElementsAreDisplayed();

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);

        defaultTimeOut = ConfigReader.getPropertyAsInt("defaultTimeOut");
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(defaultTimeOut));
    }
}
