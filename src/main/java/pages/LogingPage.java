package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LogingPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public LogingPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//button[@class='radius']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutBtn;

    @FindBy(id="flash")
    private WebElement incorrectLogInMsg;

    @FindBy(xpath = "//div[@id='flash-messages']/div")
    private WebElement logInSuccessMsg;

    public void verifyLogInFunctionality(){
        navigateToLogInPage();
        positiveLogin();
        loginFailure();
    }
    private void navigateToLogInPage(){
        driver.get(ConfigReader.getProperty("url")+"/login ");
    }

    private void positiveLogin(){
        userName.clear();
        userName.sendKeys(ConfigReader.getProperty("username"));
        password.clear();
        password.sendKeys(ConfigReader.getProperty("password"));
        softAssert.assertTrue((loginBtn.isEnabled() && loginBtn.isDisplayed()), "Login btn is not enabled or displayed");
        loginBtn.click();
        softAssert.assertTrue(logInSuccessMsg.isDisplayed(),"Log In success msg is not displayed");
        logOutBtn.click();
    }

    private void loginFailure(){
    userName.clear();
    userName.sendKeys("Admin");
    password.clear();
    password.sendKeys("Admin123");
    softAssert.assertTrue((loginBtn.isEnabled() && loginBtn.isDisplayed()), "Login btn is not enabled or displayed");
    loginBtn.click();
    softAssert.assertTrue(incorrectLogInMsg.isDisplayed(),"Incorrect Log In msg is not displayed");
    }
    }



