package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_007_DynamicControls_POM extends WT_BaseClass {
   
	//Locators
   @FindBy (xpath= "//button[contains(text(),'Remove')]")
   WebElement Removebtn;
   
   @FindBy (xpath= "//button[contains(text(),'Add')]")
   WebElement Addbtn;
   
   @FindBy (xpath= "//p[@id='message']")
   WebElement msg;
   
   @FindBy (xpath= "//input[@type='checkbox']")
   WebElement Checkbox;
   
   @FindBy (xpath= "//button[contains(text(),'Enable')]")
   WebElement Enablebtn;

   @FindBy (xpath= "//input[@type='text']")
   WebElement Textbox;
   
   @FindBy (xpath= "//button[contains(text(),'Disable')]")
   WebElement Disablebtn;
	
	//Constructor
	public WT_007_DynamicControls_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void RemoveButton() {
		Removebtn.click();
	}
	
	public WebElement CheckBox() {
		Checkbox.isDisplayed();
		return Checkbox;
	}
	
	public void AddButton() {
		Addbtn.click();
	}
	public boolean TextMessage() {
		msg.getText();
		return true;
	}
		
	public  void EnableButton() {
		Enablebtn.click();
		
	}
	public WebElement TextBox() {
		Textbox.isEnabled();
		return Textbox;
	}
	
	public void TypeText() {
    	Textbox.sendKeys("Hello");
	}
	
	public void DisableButton() {
		Disablebtn.click();	
	}
	
	
}
