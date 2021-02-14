package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseDriver{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    
	@FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;
    
    @FindBy(xpath ="//button[@type='submit']")
    public WebElement loginBtn;
    
    public void Login(String username, String password) {
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	loginBtn.click();
    }
    
    public String getFailureMessage() {
    	WebElement messageElement = driver.findElement(By.cssSelector("div#flash.flash.error"));
    	return messageElement.getText();
    }
}
