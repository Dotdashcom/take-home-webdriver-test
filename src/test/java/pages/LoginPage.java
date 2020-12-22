package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath ="//i[.=' Login']")
    public WebElement loginButton;

    @FindBy(id ="flash")
    public WebElement message;

    public void enterCredentials(String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }

    public String getMessage(){
        return message.getText();
    }

}