package com.framework.libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserInteractions {
    BrowserBucket browserBucket;
    FluentWait<WebDriver> waitForElement;
    Actions mouse;
    Boolean setExplicitDriver = false;
    JavascriptExecutor js;

    private void getExplicitDriver() {
        if (!setExplicitDriver) {
            this.waitForElement = new WebDriverWait(browserBucket.getDriver(), Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, NullPointerException.class);
            mouse = new Actions(browserBucket.getDriver());
            setExplicitDriver = true;
        }
    }

    public void click(String locator) {
        setupBrowserBucket();
        loadedElement(locator).click();
    }

    public void input(String locator, String input) {
        setupBrowserBucket();
        loadedElement(locator).sendKeys(input);
    }

    public void clear(String locator) {
        setupBrowserBucket();
        loadedElement(locator).clear();
    }

    public WebElement getWebElement(String locator) {
        setupBrowserBucket();
        return loadedElement(locator);
    }

    public WebDriver.Navigation navigate() {
        setupBrowserBucket();
        return browserBucket.getDriver().navigate();
    }


    public List<String> getWindowHandles() {
        setupBrowserBucket();
        return browserBucket.getDriver().getWindowHandles().stream().collect(Collectors.toList());
    }

    public void waitForElementToDisappear(String locator) {
        setupBrowserBucket();
        waitForElement.until(ExpectedConditions.invisibilityOf(browserBucket.getDriver().findElement(By.xpath(locator))));
    }

    public String getText(String locator) {
        setupBrowserBucket();
        return loadedElement(locator).getText();
    }

    public boolean isDisplayed(String locator) {
        setupBrowserBucket();
        return loadedElement(locator).isDisplayed();
    }

    public boolean isSelected(String locator) {
        setupBrowserBucket();
        return loadedElement(locator).isSelected();
    }

    public boolean isEnabled(String locator) {
        setupBrowserBucket();
        return loadedElement(locator).isEnabled();
    }

    public Alert switchToAlert() {
        setupBrowserBucket();
        return browserBucket.getDriver().switchTo().alert();
    }

    public WebDriver.TargetLocator switchTo(){
        return browserBucket.getDriver().switchTo();
    }

    public Actions mouseActions() {
        return mouse;
    }


    public void threadWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Select dropDown(String dropDown) {
        return new Select(I.amPerforming().getWebElement(dropDown));
    }

    public void dragAndDropInHtml5(WebElement source, WebElement target) {
        js.executeScript(""
                        + "(function( $ ) {\n"
                        + "        $.fn.simulateDragDrop = function(options) {\n"
                        + "                return this.each(function() {\n"
                        + "                        new $.simulateDragDrop(this, options);\n"
                        + "                });\n"
                        + "        };\n"
                        + "        $.simulateDragDrop = function(elem, options) {\n"
                        + "                this.options = options;\n"
                        + "                this.simulateEvent(elem, options);\n"
                        + "        };\n"
                        + "        $.extend($.simulateDragDrop.prototype, {\n"
                        + "                simulateEvent: function(elem, options) {\n"
                        + "                        /*Simulating drag start*/\n"
                        + "                        var type = 'dragstart';\n"
                        + "                        var event = this.createEvent(type);\n"
                        + "                        this.dispatchEvent(elem, type, event);\n"
                        + "\n"
                        + "                        /*Simulating drop*/\n"
                        + "                        type = 'drop';\n"
                        + "                        var dropEvent = this.createEvent(type, {});\n"
                        + "                        dropEvent.dataTransfer = event.dataTransfer;\n"
                        + "                        this.dispatchEvent($(options.dropTarget)[0], type, dropEvent);\n"
                        + "\n"
                        + "                        /*Simulating drag end*/\n"
                        + "                        type = 'dragend';\n"
                        + "                        var dragEndEvent = this.createEvent(type, {});\n"
                        + "                        dragEndEvent.dataTransfer = event.dataTransfer;\n"
                        + "                        this.dispatchEvent(elem, type, dragEndEvent);\n"
                        + "                },\n"
                        + "                createEvent: function(type) {\n"
                        + "                        var event = document.createEvent(\"CustomEvent\");\n"
                        + "                        event.initCustomEvent(type, true, true, null);\n"
                        + "                        event.dataTransfer = {\n"
                        + "                                data: {\n"
                        + "                                },\n"
                        + "                                setData: function(type, val){\n"
                        + "                                        this.data[type] = val;\n"
                        + "                                },\n"
                        + "                                getData: function(type){\n"
                        + "                                        return this.data[type];\n"
                        + "                                }\n"
                        + "                        };\n"
                        + "                        return event;\n"
                        + "                },\n"
                        + "                dispatchEvent: function(elem, type, event) {\n"
                        + "                        if(elem.dispatchEvent) {\n"
                        + "                                elem.dispatchEvent(event);\n"
                        + "                        }else if( elem.fireEvent ) {\n"
                        + "                                elem.fireEvent(\"on\"+type, event);\n"
                        + "                        }\n"
                        + "                }\n"
                        + "        });\n"
                        + "})(jQuery);"
                        + "$(arguments[0]).simulateDragDrop({ dropTarget: arguments[1]});",
                source, target
        );
    }

    public void scrollToMiddleViewOfElement(WebElement locator) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        js.executeScript(scrollElementIntoMiddle, locator);
    }

    private WebElement loadedElement(String locator) {
        completeElementCreationOnUi(locator);
        return waitForElement.until(ExpectedConditions.visibilityOf(browserBucket.getDriver().findElement(By.xpath(locator))));
    }

    private void setupBrowserBucket() {
        if (browserBucket == null) browserBucket = MyTestClasses.getObject(BrowserBucket.class);
        js = (JavascriptExecutor) browserBucket.getDriver();
        getExplicitDriver();
    }

    private void completeElementCreationOnUi(String locator) {
        double waitTime = System.currentTimeMillis() / 1000 + (15);
        WebElement element = null;
        while ((System.currentTimeMillis() / 1000) < waitTime) {
            if (browserBucket.getDriver().findElements(By.xpath(locator)).size() > 0) {
                element = browserBucket.getDriver().findElement(By.xpath(locator));
                break;
            }
        }
        if (element == null) return;
        double waitTimeForCreation = System.currentTimeMillis() / 1000 + (15);
        int iSize = element.getRect().getHeight() + element.getRect().getWidth();
        while ((System.currentTimeMillis() / 1000) < waitTimeForCreation) {
            int newSize = element.getRect().getHeight() + element.getRect().getWidth();
            if (newSize > iSize) iSize = newSize;
            else {
                break;
            }
        }
    }

}
