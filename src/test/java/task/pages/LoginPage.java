package task.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement userNameIcon;

    @FindBy(id = "password")
    public WebElement passwordIcon;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy (id ="flash")
    public WebElement assertLoginPage;



}
