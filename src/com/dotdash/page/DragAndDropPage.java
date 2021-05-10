package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/drag_and_drop";
	private WebElement[] boxes;

	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(new char[] { 'A', 'B' });
	}

	public void verifyPage(char[] chars) {
		boxes = new WebElement[] { driver.findElement(By.id("column-a")), driver.findElement(By.id("column-b")), };
		assertEquals(boxes.length, chars.length);
		for (int i = 0; i < boxes.length; i++) {
			WebElement box = boxes[i];
			assertTrue(box.isDisplayed());
			assertEquals(box.getText(), String.valueOf(chars[i]));
		}
	}

	public void dragFirstBoxToSecondBox() {
		WebElement box1 = boxes[0];
		WebElement box2 = boxes[1];
//		These do not work:
//		Actions action = new Actions(driver);
//		action.dragAndDrop(box1, box2).build().perform();
//		action.clickAndHold(box1).moveToElement(box2).release(box2).build().perform();
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
				+ "simulateHTML5DragAndDrop(source,destination);", box1, box2);
	}
}
