package Tests;

import Baseclass.BaseClass;
import Pages.ContextMenuPage;
import org.testng.annotations.Test;

public class TestsContextMenu extends BaseClass {

    @Test
    public void T004_ContextMenu_Testing() {
        ContextMenuPage context_menu_page = new ContextMenuPage(driver);
        context_menu_page.GoToContextPage();
        context_menu_page.RightClicking_Successful();
        context_menu_page.AssertAlert();




    }

}
