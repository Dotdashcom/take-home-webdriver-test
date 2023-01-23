package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.drag_and_drop_page;
import utils.Browser_Factory;

public class __4_Drag_and_Drop_test {
    String drag_and_drop = "drag_and_drop";
    WebDriver driver;

    @BeforeClass
    public void browser_fact_before() {
        driver = Browser_Factory.init_browser();

    }
    @Test
    public void Drag_and_Drop_test() {
        driver = Browser_Factory.init_url(drag_and_drop);
        drag_and_drop_page ddp = PageFactory.initElements(driver, drag_and_drop_page.class);
        ddp.Drag_and_Drop_meth();
    }
        @AfterClass
        public void browser_fact_After () throws InterruptedException {
//           driver =  Browser_Factory.teardown();
        }
    }