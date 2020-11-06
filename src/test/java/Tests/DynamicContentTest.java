package Tests;

import PageRepositories.DynamicContent;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class DynamicContentTest extends BaseTest {
    @Test(priority=1)
    @Description("Validate that the Contents Change when Dynamic Content Page is Refreshed")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Dynamic Content")
    public void check_dynamic_content_is_unique() {
        DynamicContent dynamicContent = new DynamicContent(driver);

        dynamicContent.navigate_to_dynamic_content_page(base_url);
        dynamicContent.validate_dynamic_content_page_header();
        dynamicContent.validate_the_unique_count_for_content(3);
    }
}