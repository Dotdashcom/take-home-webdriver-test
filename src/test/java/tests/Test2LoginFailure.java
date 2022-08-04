package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.LoginPage;

public class Test2LoginFailure extends GenericTest {

    @Test
    public void test2LoginFailure() {
        String url = "http://localhost:7080/login";
        String username = "tomsmith";
        String password = "SuperWrongPassword!";

        driver.get(url);
        WebElement userNameTextBox = driver.findElement(LoginPage.userNameTextBox);
        WebElement passwordTextBox = driver.findElement(LoginPage.passwordTextBox);
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        WebElement loginButton = driver.findElement(LoginPage.loginButton);
        loginButton.click();
        WebElement loginErrorLabel = driver.findElement(LoginPage.loginErrorLabel);
        Boolean isErrorLabelDisplayed = loginErrorLabel.isDisplayed();

        Assert.assertTrue(isErrorLabelDisplayed);
    }

}