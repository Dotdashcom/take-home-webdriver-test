package page_object_model.drag_and_drop_page;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends Base {
    public DragAndDropPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "column-a")
    private WebElement boxA;

    @FindBy(id = "column-b")
    private WebElement boxB;

    @FindBy(xpath = "//div[@id='column-a']/header")
    public static WebElement boxAHeader;

    @FindBy(xpath = "//div[@id='column-b']/header")
    public static WebElement boxBHeader;


    public void dragAndDropUsingJavascriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
// Use the executeScript() method to perform the drag and drop operation
        String script = "function createEvent(typeOfEvent) {\n" +
                "  var event = document.createEvent(\"CustomEvent\");\n" +
                "  event.initCustomEvent(typeOfEvent, true, true, null);\n" +
                "  event.dataTransfer = {\n" +
                "    data: {},\n" +
                "    setData: function (key, value) {\n" +
                "      this.data[key] = value;\n" +
                "    },\n" +
                "    getData: function (key) {\n" +
                "      return this.data[key];\n" +
                "    }\n" +
                "  };\n" +
                "  return event;\n" +
                "}\n" +
                "\n" +
                "function dispatchEvent(element, event, transferData) {\n" +
                "  if (transferData !== undefined) {\n" +
                "    event.dataTransfer = transferData;\n" +
                "  }\n" +
                "  if (element.dispatchEvent) {\n" +
                "    element.dispatchEvent(event);\n" +
                "  } else if (element.fireEvent) {\n" +
                "    element.fireEvent(\"on\" + event.type, event);\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "function dragAndDrop(dragElement, dropElement) {\n" +
                "  var dragStartEvent = createEvent('dragstart');\n" +
                "  dispatchEvent(dragElement, dragStartEvent);\n" +
                "  var dropEvent = createEvent('drop');\n" +
                "  dispatchEvent(dropElement, dropEvent, dragStartEvent.dataTransfer);\n" +
                "  var dragEndEvent = createEvent('dragend');\n" +
                "  dispatchEvent(dragElement, dragEndEvent, dropEvent.dataTransfer);\n" +
                "}\n" +
                "\n" +
                "dragAndDrop(arguments[0], arguments[1]);";
        js.executeScript(script, boxA, boxB);
    }

    public void dragAndDropUsingActionsClass() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(boxA, boxB).build().perform();
    }

    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(boxA)
                .moveToElement(boxB)
                .release()
                .perform();
    }


}
