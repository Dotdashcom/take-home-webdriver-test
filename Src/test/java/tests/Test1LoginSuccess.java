package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

public class Test1LoginSuccess extends chromedriver {

    @Test()
    public void test1LoginSuccess() {
        String url = "http://localhost:7080/login";
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String successTextKey = "You logged into a secure area!";

        driver.get(url);
        WebElement userNameTextBox = driver.findElement(LoginPage.userNameTextBox);
        WebElement passwordTextBox = driver.findElement(LoginPage.passwordTextBox);
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        WebElement loginButton = driver.findElement(LoginPage.loginButton);
        loginButton.click();
        WebElement successLabel = driver.findElement(SecureAreaPage.successLabel);
        Boolean successTextFlag = successLabel.getText().contains(successTextKey);
        Assert.assertTrue(successTextFlag);
    }

}