package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class DragAndDropPage extends Base {
	
	@FindBy(id="column-a")
	WebElement elementA;
	
	@FindBy(id="column-b")
	WebElement elementB;
	
	@FindBy(xpath="//*[@id='column-a']/header")
	WebElement column_a_header;
	
	@FindBy(xpath="//*[@id='column-b']/header")
	WebElement column_b_header;
	
	
	
	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void dragAndDropColumnAandB() {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("function createEvent(typeOfEvent) {\n"+"var event = document.createEvent(\"CustomEvent\");\n" 
		 +"event.initCustomEvent(typeOfEvent, true, true, null);\n"
	     +" event.dataTransfer = {\n"+" data: {},\n"                                                             
	     +" setData: function (key, value) {\n"
	     +" this.data[key] = value;\n" +" },\n"
	     +" getData: function (key) {\n" 
		 +" return this.data[key];\n" +" }\n" +" };\n" +" return event;\n" +"}\n" +"\n" 
	     +"function dispatchEvent(element, event, transferData) {\n"
		 +" if (transferData !== undefined) {\n" 
		 +" event.dataTransfer = transferData;\n" +" }\n" 
		 +" if (element.dispatchEvent) {\n" +" element.dispatchEvent(event);\n" 
	     +" } else if (element.fireEvent) {\n" 
		 +" element.fireEvent(\"on\" + event.type,event);\n" +" }\n" +"}\n" +"\n" 
		 +"function simulateHTML5DragAndDrop(element, target) {\n" 
		 +" var dragStartEvent =createEvent('dragstart');\n" 
		 +" dispatchEvent(element, dragStartEvent);\n" 
		 +" var dropEvent = createEvent('drop');\n" 
		 +" dispatchEvent(target, dropEvent,dragStartEvent.dataTransfer);\n" 
		 +" var dragEndEvent = createEvent('dragend'); \n" 
		 +" dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n"+"}\n"+"\n" 
		 +"var source = arguments[0];\n" +"var target = arguments[1];\n" 
		 +"simulateHTML5DragAndDrop(source,target);", elementA,elementB);
	}
	public String getcolumnAHeader() {
		String columnAHeader=column_a_header.getText();
		return columnAHeader;
	}
	public String getcolumnBHeader() {
		String columnBHeader=column_b_header.getText();
		return columnBHeader;
	}

}
