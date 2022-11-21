package tests;

import Pages.JsLogError_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class JsLogErrorTest {
    public String Url_javascripError="javascript_error";
    WebDriver driverDotDash;
    JsLogError_Page jsLogError_page;
    @Before
    public void setUp(){
        jsLogError_page=new JsLogError_Page(driverDotDash);
        jsLogError_page.setChrome();
        jsLogError_page.setUrl(Url_javascripError);
    }

    @Test
    public void jsLogErrorAction() {
        jsLogError_page.handleJsErrorLogs();
    }

    @After
    public void tearDown(){
        jsLogError_page.closeAllWindows();
    }
}
