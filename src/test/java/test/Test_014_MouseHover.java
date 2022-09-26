package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_014_MouseHover extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/hovers");
    }

    @Test
    public void TC001_MouseHoverTesting() {
        for (int i = 0; i < mh.imageList().size(); i++) {
            hover(mh.imageList().get(i));
            Assert.assertTrue(mh.getInfo().get(i).getText().contains("name"));
        }
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
