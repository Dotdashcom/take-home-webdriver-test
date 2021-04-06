package TakeHome.tests;

import TakeHome.pages.LoginPage;
import TakeHome.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test(groups = {"Login"})
    public void loginPositiveTest() {
        LoginPage login = new LoginPage();
        BrowserUtils.waitForPageToLoad(5);
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        login.login(username, password);

        Assert.assertTrue(login.verifySuccessMessageDisplayedCorrectly(), "Success message should have been displayed correctly but is not");
    }

    @Test(groups = {"Login"})
    public void loginNegativeTest(){
        LoginPage login = new LoginPage();
        BrowserUtils.waitForPageToLoad(5);
        String username = "Somethingrandom";
        String password = "NotSoSecret";
        login.login(username, password);
        Assert.assertTrue(login.verifyErrorMessageDisplayedCorrectly(), "Error message should have been displayed correctly but is not");
    }
}