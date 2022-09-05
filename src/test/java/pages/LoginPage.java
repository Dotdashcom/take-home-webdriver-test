package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(className = "radius")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"flash\"]")
    public WebElement errorMsg;

    @FindBy(className = "subheader")
    public WebElement subHeader;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
