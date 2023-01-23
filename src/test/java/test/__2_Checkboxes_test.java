package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.checkboxes_page;
import utils.Browser_Factory;

public class __2_Checkboxes_test {

        WebDriver driver;
        String checkboxes = "checkboxes";

        @BeforeClass
        public void browser_fact_before() {
            driver = Browser_Factory.init_browser();
        }

        @Test
        public void LoginData() {
            Browser_Factory.init_url(checkboxes);
            checkboxes_page ch = PageFactory.initElements(driver, checkboxes_page.class);
            ch.chech_box_meth();
        }

        @AfterClass
        public void browser_fact_After() throws InterruptedException {
//            driver = Browser_Factory.teardown();
        }

    }
