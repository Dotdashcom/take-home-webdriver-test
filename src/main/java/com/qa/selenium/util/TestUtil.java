package com.qa.selenium.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.DragAndDropPage;
import com.qa.selenium.pages.JavascriptAlertPage;

public class TestUtil extends TestBase {
	public static int implicitlyWait = 5;
	public static int pageLoadTimeout = 5;
	public static String alText;
	public static String jsConfirmText;
	public static String jsPromptkeys;

	public static void dragDrop() {
		DragAndDropPage d = new DragAndDropPage();
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
				+ "simulateHTML5DragAndDrop(source,destination);", d.aBox(), d.bBox());

	}

	public static void iFrameText() {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

	}

	public static void JsAlert() {
		Alert al = driver.switchTo().alert();
		alText = al.getText();
		// System.out.println(alText);
		al.accept();
	}

	public static void JsConfirm() {
		Alert al = driver.switchTo().alert();
		jsConfirmText = al.getText();
		al.accept();
	}

	public static void JsPrompt() {
		JavascriptAlertPage javascriptAlertPage;
		Alert al = driver.switchTo().alert();
		al.sendKeys(prop.getProperty("jsPromptkeys"));
		al.accept();

	}

}
