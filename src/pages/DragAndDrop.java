package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends Driver {
	
	//Locators
			public static By ColoumnA = By.cssSelector("#column-a");
			public static By ColoumnB = By.cssSelector("#column-b");
			
			
			 //javascript executor init
			static JavascriptExecutor js = (JavascriptExecutor)Driver.Instance;
			
			
					
			 
			// Navigate to DragDrop page
			public static void NavigateToDrageDropPage()
			{

				Driver.Instance.get(Baseurl+"//drag_and_drop");
			
			}
			
			// perform drag from coloumn a to coloumn b
			public static void DragAndDropFromAtoBColumn()
			{
				WebElement FromColA= Driver.Instance.findElement(ColoumnA);
				WebElement ToColB= Driver.Instance.findElement(ColoumnB);
				
				
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
	                    + "simulateHTML5DragAndDrop(source,destination);", FromColA, ToColB);
	
			}	
			
			
			//Validate coloumn a is moved to coloumn b
			public static String ValidateColumnBHeader() {
				String HeaderText= Driver.Instance.findElement(By.xpath("//*[@id='column-b']/header")).getText();
				return HeaderText;
			}

}
