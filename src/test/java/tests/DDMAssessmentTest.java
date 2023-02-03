package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class DDMAssessmentTest extends DDMBasePageTest  {
    protected DDMLoginPage loginPage;
    protected DDMCheckBoxPage checkBoxPage;
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

    @Test(priority = 2)
    public void selectCheckBoxTest()  {
        checkBoxPage = landingPage.getPageObject(DDMCheckBoxPage.class);
        checkBoxPage.selectCheckBox(0);
        Assert.assertTrue(checkBoxPage.isCheckBoxSelected(0));
    }

    @Test(priority = 3)
    public void unselectedCheckBoxTest()  {
        checkBoxPage = landingPage.getPageObject(DDMCheckBoxPage.class);
        checkBoxPage.selectCheckBox(1);
        Assert.assertFalse(checkBoxPage.isCheckBoxSelected(1));
    }
}