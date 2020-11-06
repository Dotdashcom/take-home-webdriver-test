package Tests;

import PageRepositories.FloatingMenu;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class FloatingMenuTest extends BaseTest {
    @Test(priority=1)
    @Description("Check Floating Menu Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Floating Menu")
    public void scroll_down_and_verify_floating_menu() {
        FloatingMenu floatingMenu = new FloatingMenu(driver);

        floatingMenu.navigate_to_floating_menu_page(base_url);
        floatingMenu.validate_floating_menu_page_header();
        //Scroll down by 1000 pixels
        for (int i =0; i< 5; i++) {
            floatingMenu.scroll_down_by_pixes(1000);
            floatingMenu.verify_floating_menu_is_present();
        }
    }
}
