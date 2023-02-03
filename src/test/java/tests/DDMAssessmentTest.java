package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class DDMAssessmentTest extends DDMBasePageTest  {
    protected DDMLoginPage loginPage;
    @Test(priority = 0)
    public void loginSuccessTest()  {
        loginPage = landingPage.getPageObject(DDMLoginPage.class);
        loginPage.performLogin(validUserName, validPassword);
        Assert.assertTrue(loginPage.getLoginResultMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 1)
    public void loginFailureTest()  {
        loginPage = landingPage.getPageObject(DDMLoginPage.class);
        SoftAssert softAssert = new SoftAssert();
        loginPage.performLogin("WrongUserName", validPassword);
        softAssert.assertTrue(loginPage.getLoginResultMessage().contains("Your username is invalid!"));

        loginPage.performLogin(validUserName, "WrongPassWord");
        softAssert.assertTrue(loginPage.getLoginResultMessage().contains( "Your password is invalid!"));
        softAssert.assertAll();
    }
}