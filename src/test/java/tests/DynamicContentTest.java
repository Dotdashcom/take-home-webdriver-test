package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.DynamicContent;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContentTest extends BasePage {

    DynamicContent dc;
    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.dynamicContent);
        dc=new DynamicContent();
    }
    @Test
    public boolean clickDynamicContent()
    {
        return dc.clickDynamicContent();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}

