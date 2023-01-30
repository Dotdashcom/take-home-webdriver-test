package com.ddm.pageobjects;

import com.ddm.utilties.ConfigUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class WebPage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor jse;
    protected Actions mouseAndKeyBoardActions;


    public WebPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
        mouseAndKeyBoardActions = new Actions(driver);
    }

    public <V extends WebPage> V goTo(String uri, Class<V> expectedClazz) {
        String requiredURL = ConfigUtility.getBaseURL();
        requiredURL += uri;
        driver.get(requiredURL);
        waitForPageLoad();

        return PageFactory.initElements(driver, expectedClazz);
    }

    public void waitForPageLoad() {
        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250));

        try {
            driverWait.until(isTrue -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                    .equals("complete"));
        } catch (WebDriverException e) {
            System.out.println("Driver exception occured. " + e.getMessage());
        }
    }

    public WebElement getPageHeaderElm() {
        return driver.findElement(By.cssSelector("div.example > h3"));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean isElementPresentCss(String cssSelector) {
        try {
            driver.findElement(By.cssSelector(cssSelector));
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean isElementEnabledCss(String cssSelector) {
        if(isElementPresentCss(cssSelector)) {
            WebElement elm = driver.findElement(By.cssSelector(cssSelector));
            return elm.isEnabled();
        }
        return false;
    }

    public void scrollByPage() {
        //Assuming a page is equivalent to 500 pixels verticle.
        jse.executeScript("window.scroll(0, 500)");
    }

    public boolean isElementVisibleInViewPort(String cssSelector) {
        WebElement elm = driver.findElement(By.cssSelector(cssSelector));

        return (Boolean)(jse.executeScript(
                "var elem = arguments[0],           " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , elm));
    }

    /**
     * Wait until elment is loaded
     * @param cssSelector
     */
    public void waitUntilLoadedByCss(String cssSelector) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        } catch(TimeoutException e) {
            System.out.println("Loading of an element taken more than 10 seconds." + e.getMessage());
        }
    }

    public void browserPause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception. " + e.getMessage());
        }
    }
}
