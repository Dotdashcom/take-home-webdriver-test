package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControl;

public class DynamicControlTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/dynamic_controls");
        DynamicControl control = new DynamicControl(driver);
        //control.clickRemoveButton(driver);
        //Assert.assertFalse(control.isCheckboxDisplayed());
//    control.clickAddButton(driver);
//    Assert.assertTrue(control.isCheckboxDisplayed());


        control.clickEnable(driver);
        Assert.assertTrue(control.isBoxEnable());
        control.clickDisable(driver);
        Assert.assertTrue(control.isBoxDisable());

    }
}
