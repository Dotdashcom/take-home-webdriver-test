package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_001_Loginpage_POM extends WT_BaseClass {
    
	//Locators
	@FindBy (xpath= "//input[@id='username']")
	WebElement UserName;
	
	@FindBy (xpath= "//input[@id='password']")
	WebElement Password;
	
	@FindBy (xpath= "//button[@type='submit']")
	WebElement Loginbutton;
	
	@FindBy (xpath= "//i[contains(text(),'Logout')]")
	WebElement Logoutbutton;
	
	//Constructor
	public WT_001_Loginpage_POM() {
		PageFactory.initElements(driver,this );
	}
	
	public void typeuserName(String userName) {
		UserName.sendKeys(userName);
	}
	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickloginbtn() {
		Loginbutton.click();		
	}
	public void clicklogoutbtn() {
		Logoutbutton.click();
	}
	
}
