package src.test;
import org.testng.annotations.*;
import src.main.pages.ContextMenuPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ContextMenuTest extends BaseTest {


    private ContextMenuPage contentPage;
    @Test
    public void contextMenuTest() {
        contentPage = Browser.open(baseURL + "context_menu", ContextMenuPage.class);

        contentPage.contextClickOnHotSpotBox();
        assertEquals(contentPage.getMessageFromAlert(), "You selected a context menu");
    }
}
