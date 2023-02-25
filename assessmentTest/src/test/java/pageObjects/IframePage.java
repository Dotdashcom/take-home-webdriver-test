package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class IframePage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public IframePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//locators for text field
	@FindBy (xpath = "//body[@id='tinymce']")
	WebElement txtContent;
	
	//loactor to close the alert msg 
	@FindBy (xpath = "//div[@class='tox-icon']")
	WebElement btnClose;
	
	//methods
	public String HandlingIFrame() {
		btnClose.click();
		driver.switchTo().frame(0);
		bu.EnterInInputField(txtContent, "hi! entered into iframe.", "Your Content goes here field");
		String Text = bu.getMessageText(txtContent, "Your Content goes here field");
		return Text;
	}

}
