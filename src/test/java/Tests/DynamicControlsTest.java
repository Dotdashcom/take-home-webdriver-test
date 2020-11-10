package Tests;

import PageRepositories.DynamicControls;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class DynamicControlsTest extends BaseTest {
    @Test(priority=1)
    @Description("Check the Functionality of Dynamic Controls Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Dynamic Controls")
    public void check_dynamic_control_functionality() {
        DynamicControls dynamicControls = new DynamicControls(driver);

        dynamicControls.navigate_to_dynamic_controls_page(base_url);
        dynamicControls.validate_dynamic_controls_page_header();

        dynamicControls.click_remove_button_for_checkbox();
        dynamicControls.verify_checkbox_is_removed();
        dynamicControls.click_add_button_for_checkbox();
        dynamicControls.verify_checkbox_is_present();
        dynamicControls.click_enable_button_for_text_box();
        dynamicControls.verify_text_box_is_present();
        dynamicControls.click_disable_button_for_text_box();
        dynamicControls.verify_text_box_is_not_present();
    }
}