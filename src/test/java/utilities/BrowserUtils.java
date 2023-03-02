package utilities;

import enums.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class BrowserUtils {

    public static void openPage(WebDriver driver, Pages page) {
        driver.get(page.getUrl());
    }

    public static void waitUntilStaleness(WebDriver driver, WebElement element, Duration waitAtMost) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(waitAtMost)
                .pollingEvery(Duration.ofMillis(250))
                .ignoreAll(List.of(Exception.class));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element, Duration waitAtMost) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(waitAtMost)
                .pollingEvery(Duration.ofMillis(250))
                .ignoreAll(List.of(Exception.class));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisible(WebDriver driver, WebElement element, Duration waitAtMost) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(waitAtMost)
                .pollingEvery(Duration.ofMillis(250))
                .ignoreAll(List.of(Exception.class));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilNotVisible(WebDriver driver, WebElement element, Duration waitAtMost) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(waitAtMost)
                .pollingEvery(Duration.ofMillis(250))
                .ignoreAll(List.of(Exception.class));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void dragdropByJsExecutor(WebDriver driver, WebElement from, WebElement to) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }

    public static List<String> getAllTexts(List<WebElement> webElements) {
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < webElements.size(); i++) {
            texts.add(webElements.get(i).getText());
        }
        return texts;
    }

    public static List<String> getAttributeValues(List<WebElement> webElements, String attribute) {
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < webElements.size(); i++) {
            texts.add(webElements.get(i).getAttribute(attribute));
        }
        return texts;
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        Point p = element.getLocation();
        int X = p.getX();
        int Y = p.getY();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(" + X + ", " + Y + ");");
    }

    public static void AlertSwitchGetTextAndAccept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        System.out.println("ALERT TEXT: " + alert.getText());
        alert.accept();
    }

    public static void AlertSwitchSendKeysAndAccept(WebDriver driver, String keyword) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keyword);
        alert.accept();
    }

    public static void windowHandle(WebDriver driver) {
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("Title: " + driver.getTitle());
        }
    }

    public static List<LogEntry> getBrowserLogs(WebDriver driver, Level level) {
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        return logEntries.toJson()
                .stream().filter(x -> x.getLevel().equals(level))
                .collect(Collectors.toList());
    }
}
