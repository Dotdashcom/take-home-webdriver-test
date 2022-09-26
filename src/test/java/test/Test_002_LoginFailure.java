package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_002_LoginFailure extends CommonMethods {

    public static String errorText;

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/login");
    }

    @Test(priority = 1)
    public void TC001_loginFailedTesting() {
        lg.getUserBox().sendKeys(randomsString(5));
        lg.getPassBox().sendKeys(randomsString(7));
        lg.getLoginBtn().click();
        errorText = lg.flash().getText();
        Assert.assertTrue(errorText.contains("invalid"));
    }

    @Test(priority = 2)
    public void TC002_loginPasswordFailedTesting() {
        lg.getUserBox().sendKeys(ConfigReader.getInput("user"));
        lg.getLoginBtn().click();
        errorText = lg.flash().getText();
        Assert.assertTrue(errorText.contains("password is invalid"));
    }

    @Test(priority = 3)
    public void TC003_loginEmailFailedTesting() {
        lg.getPassBox().sendKeys(ConfigReader.getInput("pass"));
        lg.getLoginBtn().click();
        errorText = lg.flash().getText();
        Assert.assertTrue(errorText.contains("username is invalid"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
