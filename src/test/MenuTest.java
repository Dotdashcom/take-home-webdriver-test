package src.test;

import org.testng.annotations.Test;
import src.main.pages.*;
import src.main.pages.FloatingMenuPage;
import src.main.utilities.Browser;

import static org.testng.AssertJUnit.assertTrue;

public class MenuTest extends BaseTest {



    private FloatingMenuPage floatingMenuPage;

    @Test
    public void floatingMenuTest() {
        floatingMenuPage = Browser.open(baseURL + "floating_menu", FloatingMenuPage.class);

        assertTrue(floatingMenuPage.isMenuDisplayed());
        Browser.scrollByPage();
        assertTrue(floatingMenuPage.isMenuDisplayed());
    }

}
