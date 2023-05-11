package utils;
import org.openqa.selenium.*;

public class BrowserUtils {
    public static void dragAndDropJS(WebDriver driver, WebElement source, WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\nvar event =document.createEvent(\"CustomEvent\");" +
                "\nevent.initCustomEvent(typeOfEvent,true, true, null);" +
                "\nevent.dataTransfer = {\ndata: {},\nsetData: function (key, value) {\nthis.data[key] = value;\n},\ngetData: function (key) {\nreturn this.data[key];\n}\n};\nreturn event;\n}\n\nfunction dispatchEvent(element, event,transferData) {\nif (transferData !== undefined) {\nevent.dataTransfer = transferData;\n}\nif (element.dispatchEvent) {\nelement.dispatchEvent(event);\n} else if (element.fireEvent) {\nelement.fireEvent(\"on\" + event.type, event);\n}\n}\n\nfunction simulateHTML5DragAndDrop(element, destination) {\nvar dragStartEvent =createEvent('dragstart');\ndispatchEvent(element, dragStartEvent);\nvar dropEvent = createEvent('drop');\ndispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\nvar dragEndEvent = createEvent('dragend');\ndispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n}\n\nvar source = arguments[0];\nvar destination = arguments[1];\nsimulateHTML5DragAndDrop(source,destination);", source, target);
    }
}
