package PageObj;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj extends CommonMethods {

    public LoginPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "username")
    private WebElement userBox;

    @FindBy(id = "password")
    private WebElement passBox;

    @FindBy(xpath = "//*[text()=' Login']")
    private WebElement loginBtn;

    @FindBy(id = "flash")
    private WebElement flash;

    @FindBy(xpath = "//h4")
    private WebElement text;

    @FindBy(xpath = "//*[@id='content']//a")
    private WebElement logOutBtn;


    public WebElement flash(){
        return flash;
    }
    public WebElement txt(){
        return text;
    }
    public WebElement getLogOutBtn(){
        return logOutBtn;
    }
    public WebElement getUserBox(){ return userBox;}
    public WebElement getPassBox(){return passBox;}
    public WebElement getLoginBtn(){return loginBtn;}

    public void validLogin(){
        userBox.sendKeys(ConfigReader.getInput("user"));
        passBox.sendKeys(ConfigReader.getInput("pass"));
        loginBtn.click();
    }



}
