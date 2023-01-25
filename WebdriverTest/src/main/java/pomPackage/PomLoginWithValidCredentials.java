package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLoginWithValidCredentials extends BaseClass  {
	
	 public PomLoginWithValidCredentials() {
		 
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy (name="username") WebElement  enterlogin;
	 
	 @FindBy (name="password") WebElement enterpassword;
	 
	 @FindBy (xpath = "//*[@id=\"login\"]/button") WebElement clickloginbutton ;
	 
	 @FindBy (id ="flash") WebElement loginsucess;
	 
	 
	 
	 public void entervalidlogincrediential() {
		 enterlogin.sendKeys("tomsmith");
		 enterpassword.sendKeys("SuperSecretPassword!");
		 clickloginbutton.click();
		 
	 }
	 public boolean sucessfulllogin() {
		   
		   return loginsucess.isDisplayed();
		   
	   }

}
