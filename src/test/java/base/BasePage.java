package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected static final Duration TIMEOUT = Duration.ofSeconds(15);
    protected static final Duration ACTION_TIMEOUT = Duration.ofSeconds(3);
    protected ChromeDriver driver;

    protected BasePage(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator, Duration timeout) {
        elementToBeClickable(locator, timeout).click();
    }

    protected void enterText(By locator, String text, Duration timeout) {
        if(text == null)	// for testdata to not enter any text in the field
            return;

        WebElement element = elementToBeClickable(locator, timeout);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator, Duration timeout) {
        return visibilityOfElementLocated(locator, timeout).getText();
    }

    protected Actions getActions() {
        return new Actions(driver);
    }

    protected Alert getAlert(Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.alertIsPresent());
    }

    protected Select getSelect(By locator, Duration timeout) {
        return new Select(elementToBeClickable(locator, timeout));
    }

    protected void switchToFrame(String id) {
        driver.switchTo().frame(id);
    }

    protected boolean isElementSelected(By locator, Duration timeout) {
        return visibilityOfElementLocated(locator, timeout).isSelected();
    }

    protected WebElement elementToBeClickable(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement visibilityOfElementLocated(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> visibilityOfAllElementsLocated(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected boolean isElementLocatedVisible(By locator, Duration timeout) {
        try {
            visibilityOfElementLocated(locator, timeout);
            return true;
        }
        catch(TimeoutException te) {
            return false;
        }
    }

    protected boolean textToBe(By locator, String text, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBe(locator, text));
    }

    /**
     * JavaScript workaround to drag and drop a web element.
     *
     * @see <a href="https://stackoverflow.com/questions/39436870/why-drag-and-drop-is-not-working-in-selenium-webdriver#answer-53930565">StackOverflow answer</a>
     * @param ElementFrom web element to drag
     * @param ElementTo web element to drop
     */
    protected void jsDragAndDrop(WebElement ElementFrom, WebElement ElementTo) {
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
                + "simulateHTML5DragAndDrop(source,destination);", ElementFrom, ElementTo);
    }
}
