package tests;

import com.qa.pages.BasePage;
import com.qa.pages.ContextMenu;
import com.qa.pages.DirectoryPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest extends BasePage {
    ContextMenu cm;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.context_menu);
        cm=new ContextMenu();
    }
    @Test
    public boolean contextClickAndAlert()
    {
        return cm.clickContectMenuAndSwitchToAlert();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
