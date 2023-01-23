package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.javascript_error_page;
import utils.Browser_Factory;

public class _15_JavaScript_Error_test {
    WebDriver driver;
    String javascript_error = "javascript_error";
    @BeforeClass
    public void browser_fact_before() {
        driver = Browser_Factory.init_browser();

    }
    @Test
    public void  JavaScript_Error_test(){
        driver = Browser_Factory.init_url(javascript_error);
        javascript_error_page jsep = PageFactory.initElements(driver, javascript_error_page.class);
        jsep.JavaScript_Error_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//      driver =  Browser_Factory.teardown();
    }
}