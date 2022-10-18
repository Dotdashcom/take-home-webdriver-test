package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_012_Iframe_POM  extends WT_BaseClass{

	//Locators
	@FindBy (xpath= "//iframe[@id='mce_0_ifr']")
	WebElement Frame;
	
	@FindBy (xpath= "//*[@id='tinymce']/p")
	WebElement Textbox;
	
	//Constructor
	public WT_012_Iframe_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void IFrame() {
		driver.switchTo().frame("mce_0_ifr");
		
	}
	
	public String WriteText() {
		Textbox.clear();
		Textbox.sendKeys("Hello World");
		return Textbox.getText();
	}
	
	
	
}

