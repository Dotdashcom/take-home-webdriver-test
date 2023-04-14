package login_page_tests;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object_model.login_page.LoginPage;
import page_object_model.secure_page.SecurePage;

public class LoginPageTest extends Base {

    @Test(priority = 1)
    public void positiveTest() {
        LoginPage loginPage = new LoginPage();
        String userName = "tomsmith";
        String password = "SuperSecretPassword!";
        loginPage.loginMethode(userName, password);
        waitForVisibilityOfElement(SecurePage.flashSuccessLoginText);
        Assert.assertTrue(SecurePage.flashSuccessLoginText.isDisplayed());
    }

    @Test(priority = 2)
    public void negativeTest() {
        LoginPage loginPage = new LoginPage();
        String userName = "tomsmith  ";
        String password = "wrongPassword";
        WebElement errorLoginMessage = LoginPage.errorMessage;
        loginPage.loginMethode(userName, password);
        waitForVisibilityOfElement(errorLoginMessage);
        Assert.assertTrue(errorLoginMessage.isDisplayed());
    }
}
