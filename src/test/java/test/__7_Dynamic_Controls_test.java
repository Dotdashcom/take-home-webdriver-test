package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dynamic_controls_page;
import utils.Browser_Factory;

public class __7_Dynamic_Controls_test {

    WebDriver driver;
    String dynamic_controls = "dynamic_controls";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void Dynamic_Controls_test() {
        driver = Browser_Factory.init_url(dynamic_controls);
        dynamic_controls_page dtp = PageFactory.initElements(driver, dynamic_controls_page.class);
        dtp.Dynamic_Controls_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//      driver =  Browser_Factory.teardown();
    }
}