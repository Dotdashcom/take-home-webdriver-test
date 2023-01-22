package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class= 'radius']")
    public WebElement logInBtn;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement actualSuccessMessage;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement errorMessage;



    public void LogIn(String userName, String passWord){
     username.sendKeys(userName);
     password.sendKeys(passWord);
     logInBtn.click();
    }
}
