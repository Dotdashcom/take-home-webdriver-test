package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPageModel extends PageObject {

    public static final String PAGE_URL = "/drag_and_drop";

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public WebElement getColumnA() {
        return columnA;
    }

    public WebElement getColumnB() {
        return columnB;
    }

    public DragAndDropPageModel(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(WebElement webElement1, WebElement webElement2) {

        // This is a work-around of an issue with
        // new Actions(driver).dragAndDrop(webElement1, webElement2).build().perform();
        ((JavascriptExecutor) driver).executeScript(compileScript(), webElement1, webElement2);
    }

    private String compileScript() {
        return "function createEvent(typeOfEvent) {\n" + "var event = document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n"
                + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);";
    }
}
