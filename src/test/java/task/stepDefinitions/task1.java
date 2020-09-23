package task.stepDefinitions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task.pages.LoginPage;
import task.utilities.ConfigurationReader;
import task.utilities.Driver;

public class task1 {

    LoginPage loginPage = new LoginPage();


    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/login");
    }


    @Test
    public void loginSuccess() {

        //Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
        loginPage.userNameIcon.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordIcon.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
        String testVPLoginPage = loginPage.assertLoginPage.getText();
        Assert.assertTrue(testVPLoginPage.contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailure() {
        loginPage.userNameIcon.sendKeys("kajgfvcjh");
        loginPage.passwordIcon.sendKeys("hgchc");
        loginPage.loginButton.click();
        String testVPLoginPage = loginPage.assertLoginPage.getText();
        Assert.assertTrue(testVPLoginPage.contains("Your username is invalid!"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }




}
