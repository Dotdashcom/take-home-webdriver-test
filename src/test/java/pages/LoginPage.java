package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    private WebDriver driver;
    //Page URL
    private static String PAGE_URL = CommonUtils.getBaseUrl() + "login";
    //Login text box
    @FindBy(id="username")
    private WebElement userName;
    //Password text box
    @FindBy(id="password")
    private WebElement userPassword;
    //Login button
    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;
    //Flash error
    @FindBy(css = "div#flash.flash.error")
    private WebElement errorText;
    //SecurePage Heading
    @FindBy(tagName = "h4")
    private WebElement headerText;

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //Method to login
    public void login(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    //Validate invalid username error
    public void validateUsernameError() {
        assertTrue(errorText.getText().contains("username is invalid"));
    }

    //Validate invalid password error
    public void validatePasswordError() {
        assertTrue(errorText.getText().contains("password is invalid"));
    }

    //method to validate valid login
    public void validateSecureHeader() {
        assertTrue(headerText.getText().contains("Welcome to the Secure Area"));
    }
}
