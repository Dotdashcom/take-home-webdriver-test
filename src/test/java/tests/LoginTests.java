package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import utils.Driver;

public class LoginTests extends TestBase {

    /**
     * 1. Login Success
     *
     * Page Object Model for the login page should be provided.
     * Test is able to login successfully.
     * Test uses an assertion to make sure User has logged in.
     *
     * 2. Login Failure
     *
     * Page Object Model for the login page should be used.
     * Test is not able to login with wrong credentials.
     * Test uses assertions to check Login failed for incorrect user and password.
     */
    @Test
    @DisplayName("Login with valid credentials")
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().findElement(By.linkText("Form Authentication")).click();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = loginPage.successMessage.getText();

        Assertions.assertEquals(expectedMessage, actualMessage, "Login message incorrect");
    }

    @Test
    @DisplayName("Login with invalid password")
    public void failureLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().findElement(By.linkText("Form Authentication")).click();
        loginPage.login("tomsmith", "wrong!");

        String expectedMessage = "Your password is invalid!";
        String actualMessage = loginPage.errorMessage.getText().trim();
        actualMessage = actualMessage.substring(0, actualMessage.indexOf("!") + 1);

        Assertions.assertEquals(expectedMessage, actualMessage, "Login message incorrect");
    }

    @Test
    @DisplayName("Login with invalid username")
    public void failureLoginTest2() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().findElement(By.linkText("Form Authentication")).click();
        loginPage.login("wrong", "wrong!");

        String expectedMessage = "Your username is invalid!";
        String actualMessage = loginPage.errorMessage.getText().trim();
        actualMessage = actualMessage.substring(0, actualMessage.indexOf("!") + 1);

        Assertions.assertEquals(expectedMessage, actualMessage, "Login message incorrect");
    }
}
