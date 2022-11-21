package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.Hovers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HoverTest extends BasePage {

    Hovers hovers;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.mouseHover);
        hovers=new Hovers();
    }
    @Test
    public boolean downloadFile()
    {
        return hovers.hoverElement();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }


}
