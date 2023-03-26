package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CommonMethods;

@Test
public class LoginSuccessTest extends CommonMethods {
    public static void main(String[]args) throws InterruptedException {

        setUp("http://localhost:7080/login");
        LoginPage login = new LoginPage();

        login.userName.sendKeys("tomsmith");
        login.password.sendKeys("SuperSecretPassword!");
        login.loginButton.click();

        boolean logoutButtonIsPresent = login.logoutButton.isDisplayed();
        Assert.assertTrue(logoutButtonIsPresent, "The test is failed. User is not able to log in");
        System.out.println("The test is passed. User has logged in with valid credentials");

        tearDown();
    }
}
