package alltests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Page Object Model for the login page
public class LoginPom {
    protected WebDriver driver;
    public LoginPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    private WebElement loginbutton;

    @FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
    private WebElement loginsuccess;

    @FindBy(xpath = "//i[contains(text(),'Logout')]")
    private WebElement loginout;

    @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
    private WebElement errorloginname;

    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    private WebElement errorloginpass;


    public void loginName(String name) {
        username.sendKeys(name);
    }

    public void loginPass(String pass) {
        password.sendKeys(pass);
    }

    public void submitLogin() {
        loginbutton.click();
    }

    public String assetLogin() {
        return loginsuccess.getText();
    }

    public void logoutClick() {
        loginout.click();
    }

    public String getErrorName() {
        return errorloginname.getText();
    }

    public String getErrorPass() {
        return errorloginpass.getText();
    }


}
