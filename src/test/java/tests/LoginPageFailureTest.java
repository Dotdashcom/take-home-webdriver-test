package tests;

import model.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class LoginPageFailureTest extends BaseTest {

    private static String wrongUserName = BaseUtils.getRandomString();
    private static String wrongPassword = BaseUtils.getRandomString();
    @DataProvider(name = "wrongUsernames")
    public Object[][] wrongUsernamesList() {
        return new Object[][]{
                {wrongUserName, wrongPassword},
                {"", ""},
                {"", BaseUtils.getCorrectPassword()},
                {wrongUserName, BaseUtils.getCorrectPassword()}
        };
    };

    @DataProvider(name = "wrongPasswords")
    public Object[][] wrongPasswordsList() {
        return new Object[][]{
                {BaseUtils.getCorrectUsername(),""},
                {BaseUtils.getCorrectUsername(),wrongPassword}
        };
    };

    @Test(dataProvider = "wrongUsernames")
    public void testWrongUsernameLoginMessage(String username, String password) {
        String expectedErrorMessage = "Your username is invalid!\n" +
                "×";
        String loggedInUrlEndpoint = "secure";
        String loggedInHeader = "Secure Area";
        LoginPage loginPage = new LoginPage(getDriver());

        String actualErrorMessage = loginPage
                .getLoginPage()
                .inputUsername(username)
                .inputPassword(password)
                .clickLoginButtonAndGetError()
                .getLoginErrorMessageText();

        String actualUrlEndpoint = loginPage
                .getCurrentUrlEndPoint();
        boolean isLoginSuccessHeaderDisplayed = loginPage.getHeaderText().contains(loggedInHeader);

        Assert.assertNotEquals(loggedInUrlEndpoint, actualUrlEndpoint);
        Assert.assertFalse(isLoginSuccessHeaderDisplayed);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(dataProvider = "wrongPasswords")
    public void testWrongPasswordLoginMessage(String username, String password) {
        String expectedErrorMessage = "Your password is invalid!\n" +
                "×";
        String loggedInUrlEndpoint = "secure";
        String loggedInHeader = "Secure Area";
        LoginPage loginPage = new LoginPage(getDriver());

        String actualErrorMessage = loginPage
                .getLoginPage()
                .inputUsername(username)
                .inputPassword(password)
                .clickLoginButtonAndGetError()
                .getLoginErrorMessageText();

        String actualUrlEndpoint = loginPage
                .getCurrentUrlEndPoint();
        boolean isLoginSuccessHeaderDisplayed = loginPage.getHeaderText().contains(loggedInHeader);

        Assert.assertNotEquals(loggedInUrlEndpoint, actualUrlEndpoint);
        Assert.assertFalse(isLoginSuccessHeaderDisplayed);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}