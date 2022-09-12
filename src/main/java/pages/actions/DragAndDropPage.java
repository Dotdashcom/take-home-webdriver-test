package pages.actions;

import org.openqa.selenium.interactions.Actions;

import base.Page;

public class DragAndDropPage extends Page{
	
	public void dragDrop() {
		Actions action = new Actions(driver);
		action.dragAndDrop(locators.boxA, locators.boxB).build().perform();
		System.out.println("successfully drag and drop from A to B");
	}
	

}
