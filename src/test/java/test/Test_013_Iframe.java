package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_013_Iframe extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/iframe");
    }

    @Test
    public void TC001_IframeTesting() {
        getDriver().switchTo().frame(iframe.getFrame());
        iframe.getTextField().clear();
        iframe.getTextField().sendKeys("Hello World");
        Assert.assertTrue(iframe.getTextField().getText().contains("Hello World"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
