package webdriver.test.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

public class DragAndDrop {

    //local webdriver variable
    private WebDriver driver;



    @FindBy(id="column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    @FindBy(xpath = "(//header)[1]")
    private WebElement header1;

    @FindBy(xpath = "(//header)[2]")
    private WebElement header2;


    //Page Class Constructor
    public DragAndDrop(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }

    public String getHeader1Text() {
        return header1.getText();
    }

    public String getHeader2Text() {
        return header2.getText();
    }


    public void JavascriptExecutorForDragAndDrop(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createCustomEvent(typeOfEvent) {\n" +
                "    var event = document.createEvent(\"CustomEvent\");\n" +
                "    event.initCustomEvent(typeOfEvent, true, true, null);\n" +
                "    event.dataTransfer = {\n" +
                "        data: {}, setData: function (key, value) {\n" +
                "            this.data[key] = value;\n" +
                "        },\n" +
                "        getData: function (key) {\n" +
                "            return this.data[key];\n" +
                "        }\n" +
                "    };\n" +
                "    return event;\n" +
                "}\n" +
                "\n" +
                "function dispatchCustomEvent(element, event, transferData) {\n" +
                "    if (transferData !== undefined) {\n" +
                "        event.dataTransfer = transferData;\n" +
                "    }\n" +
                "    if (element.dispatchEvent) {\n" +
                "        element.dispatchEvent(event);\n" +
                "    } else if (element.fireEvent) {\n" +
                "        element.fireEvent(\"on\" + event.type, event);\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "function simulateHTML5DragAndDrop(element, destination) {\n" +
                "    var dragStartEvent = createCustomEvent('dragstart');\n" +
                "    dispatchCustomEvent(element, dragStartEvent);\n" +
                "    var dropEvent = createCustomEvent('drop');\n" +
                "    dispatchCustomEvent(destination, dropEvent, dragStartEvent.dataTransfer);\n" +
                "    var dragEndEvent = createCustomEvent('dragend');\n" +
                "    dispatchCustomEvent(element, dragEndEvent, dropEvent.dataTransfer);\n" +
                "}\n" +
                "\n" +
                "var selectorDrag = arguments[0];\n" +
                "var destination = arguments[1];\n" +
                "simulateHTML5DragAndDrop(selectorDrag, destination);",columnA, columnB);
    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/drag_and_drop");
    }
}
