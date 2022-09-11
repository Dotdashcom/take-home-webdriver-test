package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.Context_Menu;

public class ContextMenuTest extends TestBase {

    @Test
    public void contextMenuTest() throws InterruptedException {
        Context_Menu context_menu = new Context_Menu(driver);
        context_menu.clickContext(driver);
        context_menu.interactAlert(driver);

    }
}
