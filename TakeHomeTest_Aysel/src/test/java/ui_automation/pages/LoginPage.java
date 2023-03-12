package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(xpath = "//*[@name ='username']")
    public WebElement username;

    @FindBy (xpath = "//*[@name ='password']")
    public WebElement password;

    @FindBy (xpath = "//*[@class = 'fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@class= 'icon-2x icon-signout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//*[@class= 'subheader']")
    public WebElement message;

    @FindBy (id = "flash")
    public WebElement errorMessage;


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
