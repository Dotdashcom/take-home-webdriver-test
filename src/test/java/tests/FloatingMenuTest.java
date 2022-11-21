package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.FloatingMenu;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BasePage {

    FloatingMenu fm;
    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.floatingMenu);
        fm=new FloatingMenu();
    }
    @Test
    public boolean downloadFile()
    {
        return fm.scrollDown();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
