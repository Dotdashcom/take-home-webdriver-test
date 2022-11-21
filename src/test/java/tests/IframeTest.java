package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.Iframe;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframeTest extends BasePage {

    Iframe ifr;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.iframe);
        ifr=new Iframe();
    }
    @Test
    public boolean downloadFile()
    {
        return ifr.switchToFrameAndTyping("this is a iframe");
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }

}
