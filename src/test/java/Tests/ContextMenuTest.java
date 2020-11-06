package Tests;

import PageRepositories.ContextMenu;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class ContextMenuTest extends BaseTest {
    @Test(priority=1)
    @Description("Right Click on Dashed Box in Context Menu Page")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Context Menu")
    public void right_click_box() {
        ContextMenu contextMenu = new ContextMenu(driver);

        contextMenu.navigate_to_context_menu_page(base_url);
        contextMenu.validate_context_menu_page_header();
        contextMenu.right_click_box_in_context_menu_page();
        contextMenu.verify_alert_message_in_context_menu_page();
        contextMenu.accept_alert_message_in_context_menu_page();
    }
}