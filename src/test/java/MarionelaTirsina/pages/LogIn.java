package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn extends BasePage {
    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;
    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash success']")
    public WebElement messageBox;

    @FindBy(xpath = "//div[@class='flash error']")
    public WebElement wrongCredentialsMessage;
}
