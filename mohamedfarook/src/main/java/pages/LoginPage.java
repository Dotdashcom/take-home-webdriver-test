package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id="username")
    public WebElement UserName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash-messages']")
    public WebElement messages;
    
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public void loginSuccess(String username,String pwd) {
    	UserName.sendKeys(username);
    	password.sendKeys(pwd);
    	loginButton.click();
    }    	
}
