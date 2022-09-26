package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_017_OpenInNewTab extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/windows");
    }

    @Test
    public void TC001_OpenInNewTabTesting() {
        op.getLinkText().click();
        switchToSecondWindow();
        String header = op.getHeader().getText();
        Assert.assertTrue(header.contains("New Window"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
