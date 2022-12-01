package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class DragAndDropTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void drag_and_drop_Test() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/drag_and_drop");
		Thread.sleep(1000);
		WebElement dropFrom = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement dropTo = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		System.out.println("Before Drag and Drop");
		System.out.println(dropFrom.getText());
		System.out.println(dropTo.getText());

		Assert.assertEquals(dropFrom.getText(), "A");
		Assert.assertEquals(dropTo.getText(), "B");
		
		Thread.sleep(2000);
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
				                    + "simulateHTML5DragAndDrop(source,destination);", dropFrom, dropTo);

		System.out.println("After Drag and Drop");
		System.out.println(dropFrom.getText());
		System.out.println(dropTo.getText());

		Assert.assertEquals(dropFrom.getText(), "B");
		Assert.assertEquals(dropTo.getText(), "A");

	}
	
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
