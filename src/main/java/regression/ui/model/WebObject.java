package regression.ui.model;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class WebObject {
    public WebDriver driver;
    private final int defaultWait = 15;

    public WebObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisibility(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(this.driver, this.defaultWait);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new Exception(String.format("Element located by %s never became visible", locator.toString()));
        }
    }

    protected void waitForElementInvisibility(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(this.driver, this.defaultWait);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new Exception(String.format("Element located by %s never became invisible", locator.toString()));
        }
    }

    public boolean doesElementExist(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    protected void dragAndDrop(WebElement from, WebElement to) {
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

    protected void refreshWebPage() {
        driver.navigate().refresh();
    }

    protected void mouseOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
