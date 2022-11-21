package tests;

import Pages.FloatingMenu_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FloatingMenuTest {
    public String Url_FlotaingMenu= "floating_menu";
    WebDriver driverDotDash;
    FloatingMenu_Page floatingMenu_page;
    @Before
    public void setUp(){
        floatingMenu_page = new FloatingMenu_Page(driverDotDash);
        floatingMenu_page.setChrome();
        floatingMenu_page.setUrl(Url_FlotaingMenu);
    }

    @Test
    public void scrollingNdAssertAction() {
        floatingMenu_page.scrollingNdAssert();
    }

    @After
    public void tearDown(){
        floatingMenu_page.closeAllWindows();
    }
}
