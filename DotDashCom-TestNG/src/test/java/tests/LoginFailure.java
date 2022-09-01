package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginFailure {
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @Test()
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"login"); //Go to "http://localhost:7080/login" URL
        ReusableMethods.waitForPageToLoad(3);

        loginPage.username.sendKeys(faker.name().username()); //Invalid username getting from "Faker class"
        loginPage.password.sendKeys(faker.internet().password()); //Invalid password getting from "Faker class"

        loginPage.loginButton.click();
        Assert.assertFalse(loginPage.Message.getText().contains("Your password is invalid!")); //Assertion
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
