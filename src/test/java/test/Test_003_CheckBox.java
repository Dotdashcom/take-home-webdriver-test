package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_003_CheckBox extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/checkboxes");
    }

    @Test(priority = 1)
    public void TC001_checkBoxDefaultTesting() {
        Assert.assertFalse(cb.checkBox1().isSelected());
        Assert.assertTrue(cb.checkBox2().isSelected());
    }

    @Test(priority = 2)
    public void TC002_checkBoxSelectedTesting() {
        cb.checkBox1().click();
        Assert.assertTrue(cb.checkBox1().isSelected());
        Assert.assertTrue(cb.checkBox2().isSelected());
    }

    @Test(priority = 3)
    public void TC003_checkBoxNotSelectedTesting() {
        cb.checkBox2().click();
        Assert.assertFalse(cb.checkBox1().isSelected());
        Assert.assertFalse(cb.checkBox2().isSelected());
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }

}
