package webdrivertestpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFailure{
    WebDriver  driver;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    WebElement login;
    @FindBy(xpath = "//div[@id='flash']")
    WebElement text;
    String loginFailure;

    public LoginFailure(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void loginFailure(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }

    public String getLoginText(){
        loginFailure = text.getText();
        return loginFailure;
    }
}
