package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class LoginPage extends GenericPage {

	@FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement messages;

    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }

    public void login(String uname, String pwd) throws InterruptedException{
    	userName.sendKeys(uname);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	Thread.sleep(2000);
    }
    
    public String getMessage() {
    	return messages.getText();
    }
}