package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Functions {

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css="button.radius")
    public WebElement loginBtn;


    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public LoginPage(){

        PageFactory.initElements(driver, this);

    }

    /**
     * Method performs login to the web application
     * @param username
     * @param password
     */
    public void login(String username, String password){
        enterText(this.username, username);
        enterText(this.password, password);
        click(loginBtn);
    }


}
