package PageObjects;

import Helpers.Helpers;
import org.apache.commons.exec.ShutdownHookProcessDestroyer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(id = "flash")
    public WebElement messageAlert;



    public void Login(String user,String pass){
        Helpers.SendText(username,user);
        Helpers.SendText(password,pass);
        Helpers.ClickElement(submit);
    }

    public boolean ValidateLoginStatus(String text){
        Helpers.WaitForElement(messageAlert);
        return messageAlert.getText().contains(text);
    }

}
