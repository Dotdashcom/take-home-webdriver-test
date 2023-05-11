package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.LoginPage;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

public class LoginFailure {



    LoginPage loginPage = new LoginPage();
    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/login");


    }


    @Test
    public void testLoginFailure() {


        loginPage.userName.sendKeys("invalidUsername");

        loginPage.password.sendKeys("WrongPassword!");

        loginPage.loginButton.click();
        BrowserUtils.waitFor(2);


        Assertions.assertTrue(loginPage.failureMessage.isDisplayed());



    }



    @AfterEach
    public void tearDown(){

        Driver.closeDriver();

    }
}
