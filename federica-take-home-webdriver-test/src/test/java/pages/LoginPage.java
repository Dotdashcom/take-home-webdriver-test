package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//i[.=' Login']")
    public WebElement loginButton;
}
