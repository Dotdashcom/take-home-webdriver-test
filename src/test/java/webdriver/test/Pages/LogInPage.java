package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;


public class LogInPage {


    //local webdriver variable
    private WebDriver driver;

    @FindBy(id="username")
    private WebElement user_name;

    @FindBy(id="password")
    private WebElement user_password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(id="flash")
    private WebElement flashMessage;



    //Page Class Constructor
    public LogInPage(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);
    }

    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/login");
    }

    //Action Methods

    public void enterUserName(String username){

        user_name.sendKeys(username);

    }

    public void enterPassWord(String password){

        user_password.sendKeys(password);

    }

    public void ClickLoginButton(){

        loginButton.click();
    }

    public String getFlashMessage(){


        return flashMessage.getText();

    }


}
