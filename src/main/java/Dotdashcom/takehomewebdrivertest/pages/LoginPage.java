package Dotdashcom.takehomewebdrivertest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;


public class LoginPage extends BaseClass{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//i[contains(text(),'Login')]")
	WebElement loginBtn;

	
	
	@FindBy(xpath="//div[@id='flash']")
	WebElement loginsuccesserrortext;
	

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String loginsucess(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	String loginsuccesserrortext1 = loginsuccesserrortext.getText();
		    	System.out.println("toast message: " +loginsuccesserrortext1);
		    	
		    	
		return loginsuccesserrortext1.trim();
	}
	public String loginfailure(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	String loginsuccesserrortext1 = loginsuccesserrortext.getText();
		    	System.out.println("toast message: " +loginsuccesserrortext1.trim());
		    	
		return loginsuccesserrortext1.trim();
	}
	
}