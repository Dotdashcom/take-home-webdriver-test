package theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[contains(.,'Login Page')]")
    public WebElement loginPageHeader;
    @FindBy(xpath = "//h4[contains(.,'This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.')]")
    public WebElement loginPageSubHeader;
    @FindBy(xpath = "//label[@for='username'][contains(.,'Username')]")
    public WebElement loginUsernameText;
    @FindBy(xpath = "//input[contains(@id,'username')]")
    public WebElement loginUsernameInputBox;
    @FindBy(xpath = "//label[@for='password'][contains(.,'Password')]")
    public WebElement loginPasswordText;
    @FindBy(xpath = "//input[contains(@id,'password')]")
    public WebElement loginPasswordInputBox;
    @FindBy(xpath = "//button[contains(.,'Login')]")
    public WebElement loginPageLoginButton;
    @FindBy(xpath = "(//div[contains(.,'Powered by Elemental Selenium')])")
    public WebElement loginPageFooterText;
    @FindBy(xpath = "//a[contains(.,'Elemental Selenium')]")
    public WebElement loginPageFooterLink;
    @FindBy(xpath = "//div[@id='flash']")
    public WebElement banner;
    @FindBy(xpath = "//a[contains(@class,'close')]")
    public WebElement bannerClose;
    @FindBy(xpath = "//h2[contains(.,'Secure Area')]")
    public WebElement loginSuccessHeader;
    @FindBy(xpath = "//a[@class='button secondary radius'][contains(.,'Logout')]")
    public WebElement loginSuccessLogoutButton;

    public Boolean validatePageLanding(){
        loginPageHeader.isDisplayed();
        loginPageSubHeader.isDisplayed();
        loginUsernameText.isDisplayed();
        loginUsernameInputBox.isDisplayed();
        loginPasswordText.isDisplayed();
        loginPasswordInputBox.isDisplayed();
        loginPageLoginButton.isDisplayed();
        loginPageFooterText.isDisplayed();
        loginPageFooterLink.isDisplayed();
        return true;
    }

    public void login(String username, String password){
        loginUsernameInputBox.sendKeys(username);
        loginPasswordInputBox.sendKeys(password);
        loginPageLoginButton.click();
        banner.isDisplayed();
        bannerClose.isDisplayed();
    }

    public void logout(){
        loginSuccessHeader.isDisplayed();
        loginSuccessLogoutButton.click();
        banner.isDisplayed();
        bannerClose.isDisplayed();
    }
    public String getBannerText(){
        return banner.getText();
    }
}
