package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webtests.BasePackage.WT_BaseClass;

public class WT_004_DragandDrop_POM extends WT_BaseClass{

	
	//Locators
	@FindBy(xpath="//div[@id='column-a']")
	WebElement ElementA;
	
	@FindBy(xpath="//div[@id='column-b']")
	WebElement ElementB; 
	
	@FindBy (xpath= "//div[@id='column-a']/header")
	WebElement HeaderA;
	
	@FindBy (xpath= "//div[@id='column-b']/header")
	WebElement HeaderB;
	
	//Constructor
	public WT_004_DragandDrop_POM() {
		
	PageFactory.initElements(driver,this );
   }
	
	public void dragAndDrop() {
		
		Actions act=new Actions(driver);
		act.dragAndDrop(ElementA, ElementB).build().perform();
	}	
  
    public WebElement TextA() {
	    HeaderA.getText();
	    return HeaderA;
   }
  
   public WebElement TextB() {
	   HeaderB.getText();
	   return HeaderB;
  }
  
 
	
}
