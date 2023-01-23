package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class drag_and_drop_page extends Base_Page {
    WebDriver driver;

    public drag_and_drop_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@id='column-a']")
    WebElement element_A;
    @FindBy(how = How.XPATH, using = "//div[@id='column-b']")
    WebElement element_B;

    public void Drag_and_Drop_meth() {
        String A = element_A.getText();
        String B = element_B.getText();
//        System.out.println("box A Before d&d : "+A);
//        System.out.println("box B Before d&d : "+B);
        Actions context = new Actions(driver);
//		context.dragAndDrop(element_A,element_B).build().perform();
        context.clickAndHold(element_A).moveToElement(element_B).release().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {" +"var event =document.createEvent(\"CustomEvent\");"
                +"event.initCustomEvent(typeOfEvent,true, true, null);"
                +"event.dataTransfer = {" +"data: {},"
                +"setData: function (key, value) {" +"this.data[key] = value;" +"},"
                +"getData: function (key) {" +"return this.data[key];" +"}"
                +"};" +"return event;" +"}" +""
                +"function dispatchEvent(element, event,transferData) {"
                +"if (transferData !== undefined) {"
                +"event.dataTransfer = transferData;" +"}"
                +"if (element.dispatchEvent) {" + "element.dispatchEvent(event);"
                +"} else if (element.fireEvent) {"
                +"element.fireEvent(\"on\" + event.type, event);" +"}" +"}" +"" +"function simulateHTML5DragAndDrop(element, colB) {"
                +"var dragStartEvent =createEvent('dragstart');" +"dispatchEvent(element, dragStartEvent);"
                +"var dropEvent = createEvent('drop');" +"dispatchEvent(colB, dropEvent,dragStartEvent.dataTransfer);"
                +"var dragEndEvent = createEvent('dragend');" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);" +"}"
                +"" +"var colA = arguments[0];" +"var colB = arguments[1];" +"simulateHTML5DragAndDrop(colA,colB);",element_A, element_B);
        String new_A = element_A.getText();
        String new_B = element_B.getText();
//        System.out.println("box A After d&d : "+new_A);
//        System.out.println("box B After d&d : "+new_B);
        check_String(A, new_B, "element switched");
        check_String(B, new_A, "element switched");

    }
}
