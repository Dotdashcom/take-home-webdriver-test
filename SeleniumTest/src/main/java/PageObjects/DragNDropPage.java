package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class DragNDropPage extends AbstractClass {
	WebDriver driver;

	public DragNDropPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "column-a")
	WebElement firstelement;
	@FindBy(id = "column-b")
	WebElement secondelement;

	public boolean dragNdrop() throws InterruptedException {

		String firstelementtext = firstelement.getText();
		String secondelementtext = secondelement.getText();

		Actions dnd = new Actions(driver);
		dnd.dragAndDrop(firstelement, secondelement).build().perform();
		Thread.sleep(3000);

		return true;
	}
}
//Actions builder = new Actions(driver);
//
//builder.keyDown(Keys.CONTROL)
//   .click(firstelement)
//   .click(secondelement)
//   .keyUp(Keys.CONTROL);
//
//// Then get the action:
//Action selectMultiple = builder.build();
//
//// And execute it:
//selectMultiple.perform();   
//Thread.sleep(5000);
//		
//	/*	String firstelementtext = firstelement.getText();
//		String secondelementtext = secondelement.getText();
//		Actions dnd = new Actions(driver);
//		dnd.dragAndDrop(firstelement, secondelement).build().perform();
//		Thread.sleep(3000);
//		
//		String newfirstelementtext = firstelement.getText();
//		String newsecondelementtext = secondelement.getText();
//		*/
//		
//		// System.out.println(newfirstelementtext);
//		// String newsecondelementtext;
////old val of a = new val of b 
////old val of b = new val a
//		
//		if (firstelementtext == newsecondelementtext && secondelementtext == newfirstelementtext ) 
//		{
//			return true; 
//		} else
//		{
//			return false;
//		}
//
//	}}
