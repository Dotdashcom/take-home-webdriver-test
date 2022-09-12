package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static support.TestSetUp.getDriver;

public class BasePage {

    protected String url;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public WebDriverWait getWait() {
        return getWait(5);
    }

    public WebDriverWait getWait(int secondsTimeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(secondsTimeout));
    }

    public void waitUntilVisibility(WebElement element, int timeout) {
        getWait(timeout).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilInvisibility(WebElement element, int timeout) {
        getWait(timeout).until(ExpectedConditions.invisibilityOf(element));
    }
}
