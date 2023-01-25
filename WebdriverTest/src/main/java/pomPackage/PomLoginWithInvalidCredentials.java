package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLoginWithInvalidCredentials extends BaseClass{
	
	public PomLoginWithInvalidCredentials() {
		 
		 PageFactory.initElements(driver,this);
	 }
	
     @FindBy (name="username") WebElement  enterlogin;
	 
	 @FindBy (name="password") WebElement enterpassword;
	 
	 @FindBy (xpath = "//*[@id=\"login\"]/button") WebElement clickloginbutton ;
	 
	 @FindBy (id="flash") WebElement loginfailalert;
	 
	 
	 public void enterinvalidcredential() {
		 enterlogin.sendKeys("tomsmith");
		 enterpassword.sendKeys("abcd");
		 clickloginbutton.click();

	 }
	 
	 public boolean loginfail() {
		 
		 return loginfailalert.isDisplayed();
		 
	 }
	
	

}
