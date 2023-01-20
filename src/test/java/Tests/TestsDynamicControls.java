package Tests;

import Baseclass.BaseClass;
import Pages.DynamicControlsPage;
import org.testng.annotations.Test;

public class TestsDynamicControls extends BaseClass {

    @Test
    public void T008_DynamicControls_Remove_Add_Testing() {
        DynamicControlsPage dynamic_controls_page = new DynamicControlsPage(driver);
        dynamic_controls_page.GoToDynamicControls();
        dynamic_controls_page.RemoveCheckbox();
        dynamic_controls_page.AssertRemoval();
        dynamic_controls_page.AddCheckbox();
        dynamic_controls_page.AssertAdding();


    }
    @Test
    public void T009_DynamicControls_Enable_Disable_Testing() {
        DynamicControlsPage dynamic_controls_page = new DynamicControlsPage(driver);
        dynamic_controls_page.GoToDynamicControls();
        dynamic_controls_page.EnableInput();
        dynamic_controls_page.AssertEnabling();
        dynamic_controls_page.DisableInput();
        dynamic_controls_page.AssertDisabling();
    }

}
