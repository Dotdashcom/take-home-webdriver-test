package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_007_DynamicContent extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/dynamic_content ");
    }

    @Test
    public void TC001_DynamicContentTesting() {

        String text1 = ct.getContentText().getText();
        getDriver().navigate().refresh();

        String text2 = ct.getContentText().getText();
        Assert.assertNotEquals(text1, text2);
        getDriver().navigate().refresh();

        String text3 = ct.getContentText().getText();
        Assert.assertNotEquals(text2, text3);
        getDriver().navigate().refresh();

        String text4 = ct.getContentText().getText();
        Assert.assertNotEquals(text3, text4);
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
