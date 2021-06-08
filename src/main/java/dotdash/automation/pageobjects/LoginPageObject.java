package dotdash.automation.pageobjects;

//import dotdash.automation.data.ContextObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class addresses all the elements and methods of Login Page and uses Builder Design Pattern
 */
public class LoginPageObject {
  //  ContextObject contextObject;
    WebDriver driver = null;

    /**
     * Id is the most stable way to find element
     * order goes like ID, Name, CSS , XPath etc
     * Source: https://medium.com/@kshitishirke/which-locator-is-faster-in-identifying-elements-in-selenium-5aeb3f943f5d
     * making elements private to make sure other classes use methods of the elements. Like getters and setters.
     */
//    private WebElement username;
//    private WebElement password ;
//    private WebElement login;

    By username = By.id("username");
    By password =By.id("password");
    By login = By.className("radius");
    By flash = By.id("flash");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;

    }


    /**
     * @param username the username that comes from test case
     * @return as user still stays in the same page after entering username it returns the instance of the class to use Builder Design Pattern
     */
    public LoginPageObject enterUsername(String username) {
        /**
         * this keyword refers to the instance of the current class. Hence this.username is class variable and username is method variable
         */
        this.driver.findElement(this.username).sendKeys(username);
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
        this.driver.findElement(this.password).sendKeys(password);
        return this;
    }

    /**
     * @return on click on Login user navigates to Secure Page Object. Hence we are returning Secure Page Object
     */
    public SecurePageObject clickLogin()  {
        this.driver.findElement(login).click();
        return new SecurePageObject(driver);
    }

    public String getFlashMessage(){
        return driver.findElement(flash).getText();
    }
}
