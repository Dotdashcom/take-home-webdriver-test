package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.utils;

public class LoginSuccessTest {
    LoginPage loginPage;
    String ExpectedResults = "Welcome to the Secure Area. When you are done click logout below.";

    public LoginSuccessTest() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginSuccessTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/login");

        loginPage.login("tomsmith", "SuperSecretPassword!");
        String ActualResults = loginPage.getMsg();

        try {
            Assert.assertEquals(ActualResults, ExpectedResults);
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