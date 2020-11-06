package Tests;

import PageRepositories.NewTab;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class NewTabTest extends BaseTest {
    @Test(priority=1)
    @Description("Test Windows New Tab Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Feature("New Tab")
    public void switch_windows_tab_test() {
        NewTab newTab = new NewTab(driver);

        newTab.navigate_to_windows_new_tab_page(base_url);
        newTab.validate_windows_new_tab_page_header();
        newTab.click_new_tab_link();
        newTab.switch_to_new_tab();
        newTab.validate_newly_open_tab_header();
    }
}
