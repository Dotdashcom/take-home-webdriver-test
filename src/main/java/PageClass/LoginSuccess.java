package PageClass;

import BaseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccess extends BaseClass {
    @FindBy(id = "username")
    WebElement user;
    @FindBy(name = "password")
    WebElement pass;
    @FindBy(xpath = "//form//button/child::i")
    WebElement login;

    public LoginSuccess() {
        PageFactory.initElements(driver, this);
    }


    public  NewPage userdetails (String un, String pwd) {
        user.sendKeys(un);
        pass.click();
        pass.sendKeys(pwd);
        login.click();
        return new NewPage();
    }

}



