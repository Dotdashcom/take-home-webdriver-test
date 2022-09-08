package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DragAndDropPage {
	static WebDriver driver;

	public DragAndDropPage(WebDriver driver) {
		DragAndDropPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//div[@id = 'column-a']")
	WebElement COLUMN_A_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id = 'column-b']")
	WebElement COLUMN_B_ELEMENT;

//	Methods
	public void dragAndDropColumnAToColumnB() {
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
				+ "simulateHTML5DragAndDrop(source,destination);", COLUMN_A_ELEMENT, COLUMN_B_ELEMENT);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateTextHasBeenSwitchFromElementBToElementA() {
		String expectedColumnAText = "B";
		String actualColumnAText = COLUMN_A_ELEMENT.getText();
		Assert.assertEquals(expectedColumnAText, actualColumnAText, "Text did not switch from element B to element A!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateTextHasBeenSwitchFromElementAToElementB() {
		String expectedColumnBText = "A";
		String actualColumnBText = COLUMN_B_ELEMENT.getText();
		Assert.assertEquals(expectedColumnBText, actualColumnBText, "Text did not switch from element A to element B!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
