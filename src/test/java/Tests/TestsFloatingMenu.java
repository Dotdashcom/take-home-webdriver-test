package Tests;

import Baseclass.BaseClass;
import Pages.FloatingMenuPage;
import org.testng.annotations.Test;

public class TestsFloatingMenu extends BaseClass {

    @Test
    public void T014_DynamicContent_Testing() {
        FloatingMenuPage floating_menu_page = new FloatingMenuPage(driver);
        floating_menu_page.GoToFloatingMenu();
        floating_menu_page.ScrollDown();
        floating_menu_page.AssertFloatingMenuExistence();


    }

}
