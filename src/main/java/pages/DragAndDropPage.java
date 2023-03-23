package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "column-a")
    protected WebElement elementA;

    @FindBy(id = "column-b")
    protected WebElement elementB;

    protected String scriptForDD = """
                function createEvent(typeOfEvent) {
                var event =document.createEvent("CustomEvent");
                event.initCustomEvent(typeOfEvent,true, true, null);
                event.dataTransfer = {
                data: {},
                setData: function (key, value) {
                this.data[key] = value;
                },
                getData: function (key) {
                return this.data[key];
                }
                };
                return event;
                }

                function dispatchEvent(element, event,transferData) {
                if (transferData !== undefined) {
                event.dataTransfer = transferData;
                }
                if (element.dispatchEvent) {
                element.dispatchEvent(event);
                } else if (element.fireEvent) {
                element.fireEvent("on" + event.type, event);
                }
                }

                function simulateHTML5DragAndDrop(element, destination) {
                var dragStartEvent =createEvent('dragstart');
                dispatchEvent(element, dragStartEvent);
                var dropEvent = createEvent('drop');
                dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);
                var dragEndEvent = createEvent('dragend');
                dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);
                }

                var source = arguments[0];
                var destination = arguments[1];
                simulateHTML5DragAndDrop(source,destination);""";


    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void performDragAndDrop() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(scriptForDD, elementA, elementB);
        pauseInSeconds(2);
    }

    public String columnAText() {
        return elementA.getText();
    }

    public String columnBText() {
        return elementB.getText();
    }
}
