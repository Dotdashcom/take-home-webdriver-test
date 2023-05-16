package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//button[@class='radius']")
    public WebElement singInButton;

    @FindBy(xpath = "//div[@class='flash success']")
    public WebElement singInMessage;


    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement failureMessage;

}
