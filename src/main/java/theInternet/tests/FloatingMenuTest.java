package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.FloatingMenu;

public class FloatingMenuTest extends TestBase {

    @Test
    public void floatingMenuTest(){
        FloatingMenu floatingMenu = new FloatingMenu(driver);
        floatingMenu.scrollFloatingMenu(driver);

    }

}
