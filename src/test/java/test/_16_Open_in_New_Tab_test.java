package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.windows_page;
import utils.Browser_Factory;

public class _16_Open_in_New_Tab_test {
    WebDriver driver;
    String windows = "windows";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void  windows_test(){
        driver = Browser_Factory.init_url(windows);
        windows_page wip  = PageFactory.initElements(driver, windows_page.class);
        wip.Open_in_New_Tab_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//     driver =   Browser_Factory.teardown();
    }
}