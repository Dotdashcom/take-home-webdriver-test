package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.utils;


public class LoginFailureTest {
    LoginPage loginPage;
    String ExpectedResults = "Welcome to the Secure Area. When you are done click logout below.";

    public LoginFailureTest() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginFailureTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/login");

        loginPage.login("wrongUsername", "wrongPassword");
        String ActualResults = loginPage.getMsg();

        try {
            Assert.assertNotEquals(ActualResults, ExpectedResults);
            System.out.println(ActualResults + "\n" + "passed");
        } catch (AssertionError e) {
            System.out.println(ExpectedResults + "\n" + "failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



