package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_012_FloatingMenu extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/floating_menu");
    }

    @Test
    public void TC001_FloatingMenuTesting() {
        scrollByPixel(600);
        for (int i = 0; i < fm.menuBar().size(); i++) {
            Assert.assertTrue(fm.menuBar().get(i).isDisplayed());
        }
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
