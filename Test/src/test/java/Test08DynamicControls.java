import pageObject.DynamicControlsPage;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test08DynamicControls extends TestBase{
    DynamicControlsPage dynamicControls;

    @Test
    public void test08DynamicControls111(){
        dynamicControls = new DynamicControlsPage(webDriver);
        
        dynamicControls.clickRemoveButton();
        Assert.assertFalse(dynamicControls.hasCheckBox());
        dynamicControls.clickAddButton();
        Assert.assertTrue(dynamicControls.hasCheckBox());
        dynamicControls.clickEnableButton();
        Assert.assertTrue(dynamicControls.isTextBoxEnabled());
        dynamicControls.clickDisableButton();
        Assert.assertFalse(dynamicControls.isTextBoxEnabled());
    }
}
