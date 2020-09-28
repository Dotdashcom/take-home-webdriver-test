package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


        @FindBy(id="username")
        private WebElement username;

        @FindBy(id="password")
        private WebElement password;

        @FindBy(xpath="//*[@type='submit']")
        private WebElement Login;

        @FindBy(xpath="//*[@class='flash error']")
        private WebElement ErrorMessage;

        @FindBy(xpath ="//*[@class='flash success']")
        private WebElement successMessage;

    public void login(String userNameStr, String passwordStr) {
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        Login.click();

        BrowserUtils.waitFor(2);
    }
    public void VerifySuccessMessage(){
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void VerifyErrorMessage(){
        Assert.assertTrue(ErrorMessage.isDisplayed());
    }

}
