package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicLoadingPage extends BasePage {
    private String path = "/dynamic_loading/2";

    private By startButtonBy = By.xpath("//div[@id='start']/button");
    private By finishTextBy = By.xpath("//div[@id='finish']/h4");

    public DynamicLoadingPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickStartButton() {
        driver.findElement(startButtonBy).click();
    }

    public void waitForLoad(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(finishTextBy, 0));
    }

    public boolean helloWorldTextDisplayed() {
        return (driver.findElements(finishTextBy).size() > 0);
    }

    public String getLoadedText() {
        return driver.findElement(finishTextBy).getText();
    }
}
