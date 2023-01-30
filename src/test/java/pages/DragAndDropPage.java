package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import base.BaseTest;

public class DragAndDropPage extends BaseTest {

	private By boxA = By.id("column-a");
	private By boxB = By.id("column-b");
	private By header1 = By.cssSelector("#column-a > header");
	private By header2 = By.cssSelector("#column-b > header");

	public void dragAndDrop() {
//		Actions act = new Actions(driver);
//		act.dragAndDrop(driver.findElement(boxA), driver.findElement(boxB)).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
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
						+ "simulateHTML5DragAndDrop(source,destination);",
				driver.findElement(boxA), driver.findElement(boxB));
	}

	public void assertDragged() {
       Assert.assertTrue(driver.findElement(header1).getText().equals("B"));
       Assert.assertTrue(driver.findElement(header2).getText().equals("A"));
	}

}
