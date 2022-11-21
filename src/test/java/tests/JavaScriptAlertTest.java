package tests;

import Pages.JavaScriptAlerts_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertTest {
    public String Url_javascriptalerts="javascript_alerts";
    WebDriver driverDotDash;
    JavaScriptAlerts_Page javaScriptAlerts_page;
    @Before
    public void setUp(){
        javaScriptAlerts_page=new JavaScriptAlerts_Page(driverDotDash);
        javaScriptAlerts_page.setChrome();
        javaScriptAlerts_page.setUrl(Url_javascriptalerts);
    }

    @Test
    public void alertNdAssert() {
        javaScriptAlerts_page.jsAlertNdAssert();
        javaScriptAlerts_page.jsConfirmNdAssert();
        javaScriptAlerts_page.jsPromptNdAssert();

    }

    @After
    public void tearDown() {
        javaScriptAlerts_page.closeAllWindows();
    }
}
