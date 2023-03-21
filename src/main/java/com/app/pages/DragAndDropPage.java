package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.app.util.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.util.PageLinks;

public class DragAndDropPage extends BasePage {

  private WebDriver driver;
	public DragAndDropPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id="column-a")
	private WebElement elementA;

	@FindBy(xpath = "//div[@id='column-a']/header")
	private WebElement textElementA;

	@FindBy(xpath = "//div[@id='column-b']/header")
	private WebElement textElementB;

	@FindBy(id="column-b")
	private WebElement elementB;



	public void verifyDragAndDropFunctionality() throws InterruptedException {
		navigateDragAndDrop();
		dragAndDrop(elementA, elementB);
		assertTrue(textElementB.getText().equalsIgnoreCase("A"), "The item didn't dragged and drop");
	}

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

	private void navigateDragAndDrop(){
		driver.get(PageLinks.DRAG_DROP_PAGE);
	}
	
}
