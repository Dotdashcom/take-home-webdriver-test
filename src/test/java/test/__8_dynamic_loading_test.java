package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dynamic_loading_page;
import utils.Browser_Factory;

public class __8_dynamic_loading_test {

    WebDriver driver;
    String dynamic_loading = "dynamic_loading/2";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void dynamic_loading_test(){
        driver = Browser_Factory.init_url(dynamic_loading);
        dynamic_loading_page dlp= PageFactory.initElements(driver, dynamic_loading_page.class);
        dlp.Dynamic_loading_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//      driver =  Browser_Factory.teardown();
    }
}