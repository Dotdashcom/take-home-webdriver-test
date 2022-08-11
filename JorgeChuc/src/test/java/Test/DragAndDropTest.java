package Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import Util.MainClass;

public class DragAndDropTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
	}
    @Test 
    public void Verify_DragAndDropTest() throws Exception 
    {   
    	driver.get("http://localhost:7080/drag_and_drop");
    	WebElement BoxB = driver.findElement(By.id("column-b"));;
		WebElement BoxA = driver.findElement(By.id("column-a"));;
		//Building a drag and drop action Selenium WebDriver Drag and Drop not working
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
				                    + "simulateHTML5DragAndDrop(source,destination);", BoxA, BoxB);
		String textB = BoxB.getText();
		String textA = BoxA.getText();
		Thread.sleep(3000);
		if((textB.toString().equals("A"))&(textA.toString().equals("B")))
           assertTrue("PASS: element dropped to target as expected", true);
        else
        	assertTrue("FAIL: element couldn't be dropped to target as expected",false); 

    }

    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
