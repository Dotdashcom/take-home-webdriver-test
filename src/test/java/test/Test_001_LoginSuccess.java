package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_001_LoginSuccess extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/login");
    }

    @Test
    public void TC001_loginSuccessTesting() {
        lg.validLogin();
        String actualText = lg.flash().getText();
        String welcomeText = lg.txt().getText();
        Assert.assertTrue(actualText.contains("logged into"));
        Assert.assertTrue(welcomeText.contains("Welcome"));
        Assert.assertTrue(lg.getLogOutBtn().isDisplayed());
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
