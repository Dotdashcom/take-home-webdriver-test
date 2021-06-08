package dotdash.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragNDropPageObject {
    private WebDriver driver;
    private WebElement colA;
    private WebElement colB;
    private Actions builder;

    public DragNDropPageObject(WebDriver driver) {
        this.driver = driver;
        this.builder = new Actions(driver);
        this.colA = driver.findElement(By.id("column-a"));
        this.colB = driver.findElement(By.id("column-b"));
    }

    public String getColAText() {
        return this.colA.getText();
    }

    public String getColBText() {
        return this.colB.getText();
    }

    public DragNDropPageObject dragAtoB() {
        return dragNDrop(colA, colB);

    }

    public DragNDropPageObject dragBtoA() {
        return dragNDrop(colB, colA);

    }

    public DragNDropPageObject dragNDrop(WebElement eleA, WebElement eleB) {
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
                + "simulateHTML5DragAndDrop(source,destination);", eleA, eleB);
        return this;
    }

}
