package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.hovers_page;
import pages.iframe_page;
import utils.Browser_Factory;

public class _12_Iframe_test {

    WebDriver driver;
    String iframe = "iframe";
    @BeforeClass
    public void browser_fact_before() {
        Browser_Factory.init_browser();

    }
    @Test
    public void Iframe_test(){
        driver = Browser_Factory.init_url(iframe);
        iframe_page ip = PageFactory.initElements(driver, iframe_page.class);
        ip.Iframe_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//   driver = Browser_Factory.teardown();
    }
}
