package com.takehomewebdrivertest;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static <T> T waitFor(WebDriver driver, ExpectedCondition<T> expectedCondition) {
        Duration duration = Duration.ofSeconds(2);
        return new WebDriverWait(driver, duration).until(expectedCondition);
    }

    public WebElement findElement(By element) throws Exception {
            return driver.findElement(element);
    }

    public static void threadSleep(int milis) throws InterruptedException {
            Thread.sleep(milis);
    }

    public String getCurrentUrl() throws Exception {
            return driver.getCurrentUrl();
    }

    public void click(By element) throws Exception {
            waitFor(driver, ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void rightClick(By element) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(element);
        actions.contextClick(elementLocator).perform();
    }

    public void sendKeys(By element, String keys) throws Exception {
            waitFor(driver, ExpectedConditions.elementToBeClickable(element)).clear();
            waitFor(driver, ExpectedConditions.presenceOfElementLocated(element)).sendKeys(keys);
    }

    public void waitForElementVisibility(By element) throws Exception {
            waitFor(driver, ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getText(By element) throws Exception {
            return driver.findElement(element).getText();
    }

    public boolean validateElementPresence(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Set<String> getWindowIds() {
        return driver.getWindowHandles();
    }

    public void switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(getWindowIds());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    public void dragAndDrop(By sourceElement, By destinationElement) {
        WebElement fromElement = driver.findElement(sourceElement);
        WebElement toElement = driver.findElement(destinationElement);
        JavascriptExecutor js = (JavascriptExecutor)driver;
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
                + "simulateHTML5DragAndDrop(source,destination);", fromElement, toElement);
    }

    public void switchToFrame(By element) throws Exception {
            driver.switchTo().frame(driver.findElement(element));
    }

    public void switchToDefaultFrame() throws Exception {
            driver.switchTo().defaultContent();
    }

    public String handleAlert(String action, String keys) {
        Alert alert = driver.switchTo().alert();
        String a = "";
        switch (action) {
            case "Accept":
                alert.accept();
                break;
            case "Dismiss":
                alert.dismiss();
                break;
            case "Text":
                a = alert.getText();
                break;
            case "Keys":
                alert.sendKeys(keys);
                break;
        }
        return a;
    }
    public boolean isFileDownloaded(String downloadPath, String fileName, Boolean deleteFile) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                if (deleteFile) {
                    dirContents[i].delete();
                }
                return true;
            }
        }
        return false;
    }

    public void hoverMouse(By element){
        WebElement ele = driver.findElement(element);
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }
}
