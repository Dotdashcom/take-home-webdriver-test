package Tests;

import Baseclass.BaseClass;
import Pages.Checkbox_Page;
import Pages.Context_Menu_Page;
import org.testng.annotations.Test;

public class Tests_ContextMenu extends BaseClass {

    @Test
    public void T004_ContextMenu_Testing() {
        Context_Menu_Page context_menu_page = new Context_Menu_Page(driver);
        context_menu_page.GoToContextPage();
        context_menu_page.RightClicking_Successful();
        context_menu_page.AssertAlert();




    }

}
