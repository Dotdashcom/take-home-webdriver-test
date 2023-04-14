package page_object_model.login_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object_model.secure_page.SecurePage;

public class LoginPage extends Base {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='radius']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash error']")
    public static WebElement errorMessage;


    public void enterUserName(String name) {
        waitForVisibilityOfElement(userName);
        userName.sendKeys(name);
    }

    public void enterPassword(String pass) {
        waitForVisibilityOfElement(password);
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);

    }

    public SecurePage loginMethode(String name, String password) {
        enterUserName(name);
        enterPassword(password);
        clickLoginButton();
        return new SecurePage();
    }

}
