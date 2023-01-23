package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.context_menu_page;
import utils.Browser_Factory;

public class __3_Context_Menu_test {
    WebDriver driver;
    String context_menu = "context_menu";

    @BeforeClass
    public void browser_fact_before() {
        Browser_Factory.init_browser();

    }

    @Test
    public void Context_Menu_test() {
        driver = Browser_Factory.init_url(context_menu);
        context_menu_page cmp = PageFactory.initElements(driver, context_menu_page.class);
        cmp.right_click_meth();
    }

    @AfterClass
    public void browser_fact_After() throws InterruptedException {
//        driver = Browser_Factory.teardown();
    }
}

