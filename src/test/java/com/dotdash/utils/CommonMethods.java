package com.dotdash.utils;

import com.dotdash.testBase.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods extends TestBase {
    static Actions mouse;

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
        return js;
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToDisappear(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void input(WebElement locator, String input) {
        locator.sendKeys(input);
    }

    public static void clear(WebElement locator) {
        loadedElement(locator).clear();
    }

    public WebDriver.Navigation navigate() {
        return BrowserFactory.getDriver().navigate();
    }


    public static List<String> getWindowHandles() {
        return BrowserFactory.getDriver().getWindowHandles().stream().collect(Collectors.toList());
    }

    public static String getText(WebElement locator) {
        return loadedElement(locator).getText();
    }

    public static boolean isDisplayed(WebElement locator) {
        return locator.isDisplayed();
    }

    public static boolean isSelected(WebElement locator) {
        return locator.isSelected();
    }

    public boolean isEnabled(WebElement locator) {
        return loadedElement(locator).isEnabled();
    }

    public static Alert switchToAlert() {
        return BrowserFactory.getDriver().switchTo().alert();
    }

    public static WebDriver.TargetLocator switchTo() {
        return BrowserFactory.getDriver().switchTo();
    }

    public static Actions mouseActions() {
        return mouse;
    }


    public static void threadWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Select dropDown(WebElement dropDown) {
        return new Select(dropDown);
    }

    public static void dragAndDropInHtml5(WebElement source, WebElement target) {
        getJSExecutor().executeScript(""
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

    public static void scrollToMiddleViewOfElement(WebElement locator) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        getJSExecutor().executeScript(scrollElementIntoMiddle, locator);
    }

    private static WebElement loadedElement(WebElement locator) {
        waitForClickability(locator);
        return getWait().until(ExpectedConditions.visibilityOf(locator));
    }

    public static void navigateTo(String endpoint) {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        BrowserFactory.getDriver().navigate().to(ConfigReader.getPropertyValue("internet-login") + endpoint);
    }

}
