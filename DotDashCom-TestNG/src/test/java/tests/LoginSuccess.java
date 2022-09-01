package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginSuccess {
    LoginPage loginPage = new LoginPage();

    @Test()
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"login"); //Go to "http://localhost:7080/login" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        loginPage.username.sendKeys(ConfigReader.getProperty("valid-username")); //Valid username getting from "Configuration.properties"
        loginPage.password.sendKeys(ConfigReader.getProperty("valid-password")); //Valid password getting from "Configuration.properties"

        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.Message.getText().contains("You logged into a secure area!")); //Assertion

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
}
}
