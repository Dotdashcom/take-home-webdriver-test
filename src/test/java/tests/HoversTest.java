package tests;

import Pages.Hovers_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HoversTest {
    public String Url_Hovers= "hovers";
    WebDriver driverDotDash;
    Hovers_Page hovers_page;
    @Before
    public void setUp(){
        hovers_page=new Hovers_Page(driverDotDash);
        hovers_page.setChrome();
        hovers_page.setUrl(Url_Hovers);
    }

    @Test
    public void hoverNdAssertAction() {
        hovers_page.hoversNdAssert();
    }
    @After
    public void tearDown(){
        hovers_page.closeAllWindows();
    }
}
