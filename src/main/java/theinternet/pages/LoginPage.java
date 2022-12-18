package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
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
    @FindBy(xpath = "//div[@class='flash success'][contains(.,'You logged into a secure area!')]")
    public WebElement loginSuccessBanner;
    @FindBy(xpath = "//a[contains(@class,'close')]")
    public WebElement bannerClose;
    @FindBy(xpath = "//h2[contains(.,'Secure Area')]")
    public WebElement loginSuccessHeader;
    @FindBy(xpath = "//h4[@class='subheader'][contains(.,'Welcome to the Secure Area. When you are done click logout below.')]")
    public WebElement loginSuccessSubHeader;
    @FindBy(xpath = "//a[@class='button secondary radius'][contains(.,'Logout')]")
    public WebElement loginSuccessLogoutButton;
    @FindBy(xpath = "//div[@class='flash success'][contains(.,'You logged out of the secure area!')]")
    public WebElement logoutSuccessBanner;

    @FindBy(xpath = "//div[@class='flash error'][contains(.,'Your username is invalid!')]")
    public WebElement loginFailedUsernameBanner;

    @FindBy(xpath = "//div[@class='flash error'][contains(.,'Your password is invalid!')]")
    public WebElement loginFailedPasswordBanner;
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
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

    public Boolean login(){
        loginUsernameInputBox.sendKeys("tomsmith");
        loginPasswordInputBox.sendKeys("SuperSecretPassword!");
        loginPageLoginButton.click();
        loginSuccessBanner.isDisplayed();
        bannerClose.isDisplayed();
        loginSuccessHeader.isDisplayed();
        loginSuccessSubHeader.isDisplayed();
        loginSuccessLogoutButton.isDisplayed();
        bannerClose.click();

        return true;
    }

    public Boolean logout(){
        loginSuccessLogoutButton.click();
        logoutSuccessBanner.isDisplayed();
        bannerClose.isDisplayed();
        bannerClose.click();

        return true;
    }

    public Boolean loginFailed(){
        loginUsernameInputBox.sendKeys("name");
        loginPasswordInputBox.sendKeys("pass!");
        loginPageLoginButton.click();
        loginFailedUsernameBanner.isDisplayed();
        bannerClose.isDisplayed();
        bannerClose.click();

        loginUsernameInputBox.sendKeys("tomsmith");
        loginPasswordInputBox.sendKeys("pass!");
        loginPageLoginButton.click();
        loginFailedPasswordBanner.isDisplayed();
        bannerClose.isDisplayed();
        bannerClose.click();

        return true;
    }
}
