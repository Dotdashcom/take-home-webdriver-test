package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.DynamicControl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BasePage {

DynamicControl dc;
    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.dynamicControls);
        dc=new DynamicControl();
    }
    @Test
    public boolean clickDynamicControlsBtns()
    {
        return dc.removeAddEnableDisable();
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}

