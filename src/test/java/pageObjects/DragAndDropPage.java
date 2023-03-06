package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage extends BaseTemplate {

	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 private final By columnA = By.id("column-a");
	 private final By columnB = By.id("column-b");
	
	 
	 private WebElement getColumnA() {
		 wait.until(ExpectedConditions.elementToBeClickable(columnA));
	        return driver.findElement(columnA);
	    }

	 private WebElement getColumnB() {
		 wait.until(ExpectedConditions.elementToBeClickable(columnB));
	        return driver.findElement(columnB);
	    }
	 public String getcolumnAText() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(columnA));
		 return driver.findElement(columnA).getText();
	 }
	 public String getcolumnBText() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(columnB));
		 return driver.findElement(columnB).getText();
	 }
	 
	 public void performDragAndDrop() {
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
				                     + "simulateHTML5DragAndDrop(source,destination);", getColumnA(), getColumnB());
	    }
	

}
