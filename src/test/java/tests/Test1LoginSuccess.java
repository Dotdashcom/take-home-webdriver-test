package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

public class Test1LoginSuccess {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
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

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}