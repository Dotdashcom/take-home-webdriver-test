package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginBtn;

    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
