package tests;

import Pages.ContextMenu_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ContextMenuTest{
    public  String ContextMenuUrl = "context_menu";
    WebDriver driverDotDash;
    ContextMenu_Page contextMenu_page=new ContextMenu_Page(driverDotDash);
    @Before
    public void setUp()  {
        contextMenu_page=new ContextMenu_Page(driverDotDash);
        contextMenu_page.setChrome();
        contextMenu_page.setUrl(ContextMenuUrl);
    }

    @Test
    public void excecuteRightClick(){
        contextMenu_page.rightClickAndAssert();
        contextMenu_page.assertRightClick();

    }

    @After
    public void tearDown() {
        contextMenu_page.implicitWait(5);
        contextMenu_page.dissmissOrAcceptAlert(true);
        contextMenu_page.closeAllWindows();
    }

}
