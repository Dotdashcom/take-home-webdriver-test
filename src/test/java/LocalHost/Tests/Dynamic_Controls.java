package LocalHost.Tests;

import LocalHost.Pages.Dynamic_Controls_Page;
import org.testng.annotations.Test;

public class Dynamic_Controls extends TestingBase{

    @Test(groups = "Dynamic_Control")
    public void TestCheckbox(){
        Dynamic_Controls_Page dynamicControlsPage = new Dynamic_Controls_Page();
        dynamicControlsPage.WaitForCheckbox();
        dynamicControlsPage.ConfirmRemovalCheckbox();
        dynamicControlsPage.WaitForCheckbox();
        dynamicControlsPage.ConfirmAdditionCheckbox();

    }

    @Test(groups="Dynamic_Control")
    public void TestInputBox(){
        Dynamic_Controls_Page dynamicControlsPage = new Dynamic_Controls_Page();
        dynamicControlsPage.WaitForInputBox();
        dynamicControlsPage.ConfirmAdditionInput();
        dynamicControlsPage.WaitForInputBox();
        dynamicControlsPage.ConfirmRemovalInput();
    }
}
