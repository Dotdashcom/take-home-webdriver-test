package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DynamicControlsPage;
import testComponents.BaseTest;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls(){
        DynamicControlsPage dynamicCntrl=new DynamicControlsPage(driver);
        dynamicCntrl.goTo();
        dynamicCntrl.clickOnRemove();
        Assert.assertFalse(dynamicCntrl.checkboxDisplay());
        dynamicCntrl.cilckAdd();
        Assert.assertTrue(dynamicCntrl.checkboxDisplay());
        dynamicCntrl.clickEnable();
        Assert.assertFalse(dynamicCntrl.bar());
        dynamicCntrl.clickDisable();
        Assert.assertTrue(dynamicCntrl.bar());



    }
}
