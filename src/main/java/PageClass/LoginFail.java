package PageClass;

import BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFail extends BaseClass {
    @FindBy(id = "username")
    WebElement user;
    @FindBy(name = "password")
    WebElement pass;
    @FindBy(xpath = "//form//button/child::i")
    WebElement login;
    @FindBy(id= "flash")
    WebElement errormsg;

    public LoginFail(){
        PageFactory.initElements(driver,this);
    }
    public NewPage logindetails(String un,String PWD){
        user.sendKeys(un);
        pass.click();
        pass.sendKeys(PWD);
        login.click();
        return new NewPage();
    }
    public boolean VerifyError(){
        boolean error = errormsg.isDisplayed();
        return error;
    }

}
