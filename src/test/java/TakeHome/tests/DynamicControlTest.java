package TakeHome.tests;

import TakeHome.pages.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlTest extends TestBase{

    @Test(groups = "Dynamic_Control")
    public void dynamicCheckboxTest(){
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.getCheckButtonName(), "Add", "Dynamic checkbox name should be changed to 'Add' but is not");
        dynamicControlsPage.clickCheckbox();
        Assert.assertEquals(dynamicControlsPage.getCheckButtonName(), "Remove", "Dynamic checkbox name should be changed to 'Remove' but is not");

    }

    @Test(groups="Dynamic_Control")
    public void dynamicTestInputBoxTest(){
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.clickInputBox();
        Assert.assertEquals(dynamicControlsPage.getInputBoxName(), "Enable", "Dynamic inputbox name should be changed to 'Disable' but is not");
        dynamicControlsPage.clickInputBox();
        Assert.assertEquals(dynamicControlsPage.getInputBoxName(), "Disable", "Dynamic inputbox name should be changed to 'Enable' but is not");
    }
}


