package src.test;

import org.testng.annotations.Test;
import src.main.pages.CheckBoxesPage;
import src.main.pages.TabsPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TabsTest extends BaseTest {



    private TabsPage tabsPage;

    @Test
    public void newTabTest() {
        tabsPage = Browser.open(baseURL + "windows", TabsPage.class);
        tabsPage.openNewWindow();
        tabsPage.switchToNewWindow();
        assertEquals(tabsPage.getNewWindowText(), "New Window");
        tabsPage.switchToParentWindow();
    }

}
