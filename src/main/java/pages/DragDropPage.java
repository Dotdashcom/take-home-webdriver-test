package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class DragDropPage extends TestBase {
    WebDriver driver = TestBase.getInstance().getDriver();
    @FindBy(xpath = "(//div[@id='column-a'])[1]")
    WebElement boxA;
    @FindBy(xpath = "(//div[@id='column-b'])[1]")
    WebElement boxB;
    @FindBy(css = "div#column-a > header")
    WebElement textA;
    @FindBy(css = "div#column-b > header")
    WebElement textB;

    public DragDropPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void dragDrop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");" +
                "\n" + "event.initCustomEvent(typeOfEvent,true, true, null);" +
                "\n" + "event.dataTransfer = {\n" + "data: {}," +
                "\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "}," +
                "\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};" +
                "\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData)" +
                " {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}" +
                "\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} " +
                "else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n"
                + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');" +
                "\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');" +
                "\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);" +
                "\n" + "var dragEndEvent = createEvent('dragend');" +
                "\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);" +
                "\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];" +
                "\n" + "simulateHTML5DragAndDrop(source,destination);", boxA, boxB);

    }

    public String getTextA() {
        return textA.getText();
    }

    public String getTextB() {
        return textB.getText();
    }
}
