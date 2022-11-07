package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
    public WebDriver driver;

    public DynamicContentPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(id = "flash")
    private WebElement messageAlert;



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
