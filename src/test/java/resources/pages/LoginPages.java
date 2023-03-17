package resources.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class LoginPages extends BaseClass {

    public LoginPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input#username")
    WebElement username;

    @FindBy(css="input#password")
    WebElement password;

    @FindBy(css="i.fa-sign-in")
    WebElement login;

    @FindBy(css="div#flash")
    WebElement loginText;

    public void login(String uname,String pword) {
        System.out.println("*****"+username+"******");
        username.sendKeys(uname);
        password.sendKeys(pword);
    }

    public void clickLoginButton() {
        login.click();
    }

    public String checkLoginText() {
        String loginSuccess=loginText.getText();
        return loginSuccess;
    }
}
