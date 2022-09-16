package faridun.Pages;

import faridun.utils.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Base {

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[21]/a")
    public WebElement formAuthenticationLink;

    @FindBy(xpath = "//h2[text()='Login Page']")
    public WebElement loginHeaderTXT;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameTxtBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTxtBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement loggedinTxtToVerify;

    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement invalidFailedLoginTxt;

    // methods specific to a page

    public void goToLogIn() {
        formAuthenticationLink.click();
    }

    public void typeCredentials(String userName, String password) {
        sendText(userNameTxtBox,userName);
        sendText(passwordTxtBox,password);
        click(loginButton);
    }

}
