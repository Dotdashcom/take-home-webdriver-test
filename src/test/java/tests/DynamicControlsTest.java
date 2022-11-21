package tests;

import Pages.DynamicControls_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DynamicControlsTest {
    public String Url_DynamicControls= "dynamic_controls";
    WebDriver driverDotDash;
    DynamicControls_Page dynamicControls_page;
    @Before
    public void setUp(){
        dynamicControls_page=new DynamicControls_Page(driverDotDash);
        dynamicControls_page.setChrome();
        dynamicControls_page.setUrl(Url_DynamicControls);
    }

    @Test
    public void dynamicControlClickNdAssert() {
        dynamicControls_page.removeAddBtn();
        dynamicControls_page.enableDisableBtn();
    }

    @After
    public void tearDown(){
        dynamicControls_page.closeAllWindows();
    }
}
