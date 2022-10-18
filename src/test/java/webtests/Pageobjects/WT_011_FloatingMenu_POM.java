package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_011_FloatingMenu_POM extends WT_BaseClass {
 
	//Locators
	@FindBy(xpath= "//div[@id='menu']")
	WebElement menu;
	
	@FindBy(xpath= "//h3[contains(text(),'Floating Menu')]")
	WebElement Floatingmenu;
	
	
	//Constructor
	public WT_011_FloatingMenu_POM(){
		PageFactory.initElements(driver,this );
	}
	
	public Boolean Menu() {
		return menu.isDisplayed();
	}
	
}
