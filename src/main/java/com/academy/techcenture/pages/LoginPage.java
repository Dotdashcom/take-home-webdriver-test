package com.academy.techcenture.pages;

import static com.academy.techcenture.configReader.ConfigReader.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class LoginPage extends SecurePage{

    public LoginPage(WebDriver driver, SoftAssert softAssert){
        super(driver, softAssert);
    }

    @FindBy (xpath = "//input[@id='username']")
    private WebElement loginInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//i[contains(text(),'Login')]")
    private WebElement loginBtn;

    @FindBy (xpath = "//div[@id='flash-messages']")
    private WebElement loginMsg;

    @FindBy (tagName = "h4")
    private WebElement welcomeMsg;



    public void login(){
        navigateTo("/login");
        verifyLoginPage();
        loginInput.sendKeys(getProperty("user"));
        passwordInput.sendKeys(getProperty("password"));
        loginBtn.click();
        verifySecurePage();
        logout();
    }

    public void loginNegative(){
        navigateTo("/login");
        verifyLoginPage();
        loginInput.sendKeys(getProperty("usernameInc"));
        passwordInput.sendKeys(getProperty("passwordInc"));
        loginBtn.click();
        softAssert.assertTrue(loginMsg.getText().contains("Your username is invalid!"),"Login message is not match");
        softAssert.assertTrue(welcomeMsg.getText().contains("This is where you can log into the secure area. Enter tomsmith " +
                        "for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages"),
                "Welcome message is not match");
        verifyLoginPage();
    }

    private void verifyLoginPage(){
        softAssert.assertEquals(driver.getTitle(),"The Internet", "Title of login page is not match");
        softAssert.assertTrue(loginInput.isEnabled(),"Login input is not enabled");
        softAssert.assertTrue(passwordInput.isEnabled(),"Password input is not enabled");
        softAssert.assertTrue(loginBtn.isEnabled(),"Login button is not enabled");
    }

}
