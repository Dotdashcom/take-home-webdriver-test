package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "username]")
    public WebElement textBox_Username;

    @FindBy(id = "password")
    public WebElement textBox_Password;

    @FindBy(xpath = "//*[@id=\"login\"]/button")
    public WebElement button_Login;

    @FindBy(xpath = "//*[text()=' Logout']")
    public WebElement button_Logout;

    @FindBy(id = "flash")
    public WebElement message_Error;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean verifyLoginFunctioniality(String username,String password){
        boolean isLoginverified = false;
        if(textBox_Username.isDisplayed()){
            textBox_Username.sendKeys(username);
            textBox_Password.sendKeys(password);
            button_Login.click();
            if(button_Logout.isDisplayed()) {
                isLoginverified = true;
                Reporter.log("Login successful with given credentials");
            }
            else if(message_Error.isDisplayed()&&message_Error.getAttribute("text").contains("invalid")){
                Reporter.log("Login not successful with given credentials");
            }
        }else
            Reporter.log("Login page  loaded as expected.");
        return isLoginverified;
    }

}
