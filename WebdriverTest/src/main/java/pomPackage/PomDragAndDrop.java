package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomDragAndDrop extends BaseClass {

	Actions action = new Actions (driver);
	public PomDragAndDrop() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath= "//div[@class='column'and @id='column-a']") WebElement boxA;
	@FindBy (xpath = ("//div[@class='column'and @id='column-b']")) WebElement boxB;
	
	@FindBy (xpath ="//*[@id=\"column-a\"]/header") WebElement textA;
	
	@FindBy (xpath = "//*[@id=\"column-b\"]/header") WebElement textB;
	
	
	public void draganddrop() throws InterruptedException {
		
		
		
		
		action.clickAndHold(boxA).moveToElement(boxB).release().perform();;
		
		/*action.moveToElement(boxB);
		
		action.release().perform();*/
		//action.dragAndDrop(boxA, boxB).build().perform();;
		//action.moveToElement(boxB);
		
		//action.build().perform();
		
		Thread.sleep(3000);
	}
	
	public String varifydraganddrop() {
		
	action.moveToElement(textA).build().perform();
	String headerA =driver.getTitle();
	
	action.moveToElement(textB).build().perform();
	String headerB=driver.getTitle();
	return headerA;
	
	
	
	
		
		
		
		
	}
	
}
