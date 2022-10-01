package Pages;
import Util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    @FindBy(id="username")
    public WebElement login;
    @FindBy(id="password")
    public WebElement password;
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
