package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_003_ContextMenu_POM extends WT_BaseClass {

	//Locators
	@FindBy(id= "hot-spot")
	WebElement ContextSquareBox;
	
	//Constructor
	public WT_003_ContextMenu_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void contextvalidation() {
		
		Actions action =new Actions(driver);
		action.moveToElement(ContextSquareBox);
		
		action.contextClick().build().perform();
				
	}
}
