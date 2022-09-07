package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class LoginPage extends TestBase {
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//h4[@class='subheader']")
    WebElement loginMsg;

    public LoginPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void login(String uname, String pwd) {
        userName.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
    }

    public String getMsg() {
        return loginMsg.getText();
    }


}
