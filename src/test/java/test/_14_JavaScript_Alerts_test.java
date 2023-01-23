package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.javascript_alerts_page;
import utils.Browser_Factory;

public class _14_JavaScript_Alerts_test {
    WebDriver driver;
    String javascript_alerts = "javascript_alerts";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void  JavaScript_Alerts_test(){
        driver = Browser_Factory.init_url(javascript_alerts);
        javascript_alerts_page jsp = PageFactory.initElements(driver, javascript_alerts_page.class);
        jsp.JavaScript_Alerts_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//       driver =  Browser_Factory.teardown();
    }
}