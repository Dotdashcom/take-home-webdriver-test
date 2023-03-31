package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDown;

public class DropDownTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/dropdown");
        DropDown clickOptions = new DropDown(driver);
        clickOptions.optionsClick(driver);
        clickOptions.opion1Click(driver);
        Assert.assertTrue(clickOptions.isOption1Selected());
        clickOptions.optionsClick(driver);
        clickOptions.opion2Click(driver);
        Assert.assertTrue(clickOptions.isOption2Selected());

    }
}
