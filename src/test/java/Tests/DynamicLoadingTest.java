package Tests;

import PageRepositories.DynamicLoading;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class DynamicLoadingTest extends BaseTest {
    @Test(priority=1)
    @Description("Check the Functionality of Dynamic Loading Page - Example 2")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Dynamic Loading")
    public void check_dynamic_loading_functionality_example2() {
        DynamicLoading dynamicLoading = new DynamicLoading(driver);

        dynamicLoading.navigate_to_dynamic_loading_page_example2(base_url);
        dynamicLoading.validate_dynamic_loading_page_header_context_path_2();
        dynamicLoading.click_start_button_for_rendering();
        dynamicLoading.verify_rendered_text_displayed();
    }
}