package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(css = ".fa-sign-in")
    public WebElement loginBtn;
    @FindBy(id = "flash")
    public WebElement successMessage;


    public void Login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }


}
