package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CommonMethods;
@Test
public class LoginFailureTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        setUp("http://localhost:7080/login");
        LoginPage login = new LoginPage();

        login.userName.sendKeys("tom");
        login.password.sendKeys("Super");
        login.loginButton.click();

        boolean loginButtonIsPresent = login.loginButton.isDisplayed();
        Assert.assertTrue(loginButtonIsPresent, "The test is failed");
        System.out.println("The test is passed. User cannot login with invalid credentials");

       tearDown();
    }
}

