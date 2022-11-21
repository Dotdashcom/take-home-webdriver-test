package tests;

import Pages.DynamicContent_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DynamicContentTest {
    public String Url_DynamicContent= "dynamic_content";
    WebDriver driverDotDash;
    DynamicContent_Page dynamicContent_page;

    @Before
    public void setUp() {
        dynamicContent_page=new DynamicContent_Page(driverDotDash);
        dynamicContent_page.setChrome();
        dynamicContent_page.setUrl(Url_DynamicContent);
    }

    @Test
    public void refreshF5() {
        dynamicContent_page.refreshThePageNdAssert(3);
    }

    @After
    public void tearDown() {
        dynamicContent_page.closeAllWindows();
    }
}
