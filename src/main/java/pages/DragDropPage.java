package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage extends BasicPage {
    WebDriver driver;
    Actions builder;
    String fromText;
    String toText;

    @FindBy(id = "column-a")
    WebElement fromElement;

    @FindBy(id = "column-b")
    WebElement toElement;

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/drag_and_drop");
        this.builder = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void dragDropElement() {
        this.fromText = this.fromElement.getText();
        this.toText = this.toElement.getText();
        this.dragAndDrop(this.fromElement, this.toElement);
        //this.builder.dragAndDrop(this.fromElement, this.toElement).build().perform();
    }

    // Reference: https://stackoverflow.com/a/62574134
    public void dragAndDrop(WebElement from, WebElement to) {
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
                + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }

    public void assertSwitchText() {
        try {
            Assert.assertEquals(this.toText, this.fromElement.getText());
            Assert.assertEquals(this.fromText, this.toElement.getText());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
