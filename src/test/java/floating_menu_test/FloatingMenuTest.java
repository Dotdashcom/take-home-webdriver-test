package floating_menu_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.floating_menu_page.FloatingMenuPage;

import static org.testng.Assert.assertTrue;

public class FloatingMenuTest extends Base {
    @Test
    public void floatingMenuTest(){
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
        floatingMenuPage.scrollDown();
        assertTrue(FloatingMenuPage.menu.isDisplayed());
    }
}
