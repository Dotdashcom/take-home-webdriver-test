package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFailurePage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement loginButtonInput;

    @FindBy(id = "flash")
    private WebElement flashMessageInput;


    /**
     * Open the browser
     */
    @BeforeClass
    public static void setUp()throws Exception{
        DriverTest.getDriver().get("http://localhost:7080/login");
    }


    @Test
    public void loginWithInvalidUserName(){
        waitForVisibilityOf(usernameInput);
        usernameInput.sendKeys("tomsmit");
        passwordInput.sendKeys("SuperSecretPassword!");
        waitForVisibilityOf(loginButtonInput);
        loginButtonInput.click();
        assertTheTextMessage(this.getClass().getSimpleName(),flashMessageInput,"Your username");
    }

    @Test
    public void loginWithInvalidPassword(){
        waitForVisibilityOf(usernameInput);
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword");
        waitForVisibilityOf(loginButtonInput);
        loginButtonInput.click();
        assertTheTextMessage(this.getClass().getSimpleName(),flashMessageInput,"Your password");
    }

    /**
     * Tear down the driver
     */
    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}
