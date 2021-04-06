package TakeHome.pages;

import TakeHome.utilities.BrowserUtils;
import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//*[@type='submit']")
    private WebElement login;

    @FindBy(xpath="//*[@class='flash error']")
    private WebElement errorMessage;

    @FindBy(xpath ="//*[@class='flash success']")
    private WebElement successMessage;

    public void login(String userNameStr, String passwordStr) {
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        login.click();
        BrowserUtils.waitFor(2);
    }

    public boolean verifySuccessMessageDisplayedCorrectly(){
        return successMessage.isDisplayed() && successMessage.getText().contains("You logged into a secure area!");
    }

    public boolean verifyErrorMessageDisplayedCorrectly(){
        return errorMessage.isDisplayed() && errorMessage.getText().contains("Your username is invalid!");
    }

}
