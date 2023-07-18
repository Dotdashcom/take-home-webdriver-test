package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DynamicControlsPage;
import testComponents.BaseTest;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls()  {
        DynamicControlsPage dynamicCntrl=new DynamicControlsPage(driver);
        dynamicCntrl.goTo();
        dynamicCntrl.clickOnRemove();
        boolean text=dynamicCntrl.message();
        System.out.println(text);
        Assert.assertTrue(text);
        dynamicCntrl.cilckAdd();
        Assert.assertTrue(dynamicCntrl.checkboxDisplay());
        dynamicCntrl.clickEnable();
        Assert.assertTrue(dynamicCntrl.bar());
        dynamicCntrl.clickDisable();
        Assert.assertFalse(dynamicCntrl.bar());



    }
}
