package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    WebDriver driver;
    LoginPage loginPage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath="//i[@class='fa fa-2x fa-sign-in']")
    public WebElement loginButton;

    @FindBy(xpath = "//div/h2")
    public WebElement secureArea;

    @FindBy(xpath = "//div[@class='row']/div/div")
    public WebElement invalidlogin;

}
