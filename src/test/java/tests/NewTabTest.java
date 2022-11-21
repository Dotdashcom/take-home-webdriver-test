package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.NewTab;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTabTest extends BasePage {

    NewTab nt;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.openNewTab);
        nt=new NewTab();
    }
    @Test
    public void JavaScriptError(){
        Assert.assertTrue(nt.isNewWindow());
    }
    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
