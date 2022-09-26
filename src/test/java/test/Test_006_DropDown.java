package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_006_DropDown extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/dropdown ");
    }

    @Test
    public void TC001_DropdownTesting() {
        selectDropDown(ddp.DropDown(), "Option 1");
        Assert.assertTrue(ddp.option1().isSelected());

        selectDropDown(ddp.DropDown(), "Option 2");
        Assert.assertTrue(ddp.option2().isSelected());
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }

}
