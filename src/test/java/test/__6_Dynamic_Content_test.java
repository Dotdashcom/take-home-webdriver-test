package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dynamic_content_page;
import utils.Browser_Factory;

public class __6_Dynamic_Content_test {

    WebDriver driver;
    String dynamic_content = "dynamic_content";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void Dynamic_Content_test(){
        driver = Browser_Factory.init_url(dynamic_content);
        dynamic_content_page dcp = PageFactory.initElements(driver, dynamic_content_page.class);
        dcp.Dynamic_Content_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//        driver = Browser_Factory.teardown();
    }
}
