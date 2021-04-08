package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy (id = "password")
    public WebElement passWord;

    @FindBy (xpath = "//button[@type = 'submit']")
    public WebElement loginBtn;

    @FindBy (id = "flash")
    public WebElement alertMsg;

    @FindBy(css = "#content>div>h2")
    public WebElement title;

}
