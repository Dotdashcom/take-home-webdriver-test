package Pages;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passWord;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement button;

    @FindBy(css = ".flash")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement successMessage;

    @FindBy(xpath = "//a[@href = '/logout']")
    private WebElement logOutButton;

    public void LoginWithCorrectCredentials(String username,String userPassword) {
        HelpfulMethods.staticWait(3);
        userName.sendKeys(username);
        passWord.sendKeys(userPassword);
        button.click();
    }

    public void LoginWithInvalidCredentials(String InvalidUsername, String InvalidUserPassword) {
        userName.sendKeys(InvalidUsername);
        HelpfulMethods.staticWait(3);
        passWord.sendKeys(InvalidUserPassword);
        button.click();

    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
    public String successMessage(){
        return successMessage.getText();
    }
    public void logOut(){
        logOutButton.click();
    }
}
