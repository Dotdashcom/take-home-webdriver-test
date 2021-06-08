package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class addresses all the elements and methods of Login Page and uses Builder Design Pattern
 * No Assertions in the Page Objects. They are in the TC level.
 * Page Elements are private. Necessary element actions are created as public methods.
 */
public class LoginPageObject extends BasePageObject {

    /**
     * Id is the most stable way to find element
     * order goes like ID, Name, CSS , XPath etc
     * Source: https://medium.com/@kshitishirke/which-locator-is-faster-in-identifying-elements-in-selenium-5aeb3f943f5d
     * making elements private to make sure other classes use methods of the elements. Like getters and setters.
     */
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(className = "radius")
    private WebElement login;
    @FindBy(id = "flash")
    private WebElement flash;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }


    /**
     * @param username the username that comes from test case
     * @return as user still stays in the same page after entering username it returns the instance of the class to use Builder Design Pattern
     */
    public LoginPageObject enterUsername(String username) {
        /**
         * this keyword refers to the instance of the current class. Hence this.username is class variable and username is method variable
         */
        this.username.sendKeys(username);
        return this;
    }

    /**
     * @param password the password that comes from test case
     * @return as user still stays in the same page after entering password it returns the instance of the current class to use Builder Design Pattern
     */
    public LoginPageObject enterPassword(String password) {
        /**
         * this keyword refers to the instance of the current class. Hence this.password is class variable and password is method variable
         */
        this.password.sendKeys(password);
        return this;
    }

    /**
     * @return on click on Login user navigates to Secure Page Object. Hence we are returning Secure Page Object
     * We are passing the same driver which is already instantiated
     */
    public SecurePageObject clickLogin() {
        this.login.click();
        return new SecurePageObject(getDriver());
    }

    public String getFlashMessage() {
        return flash.getText();
    }
}
