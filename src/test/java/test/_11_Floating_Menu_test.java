package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.floating_menu_page;
import utils.Browser_Factory;

public class _11_Floating_Menu_test {
    WebDriver driver;
    String floating_menu = "floating_menu";
    @BeforeClass
    public void browser_fact_before() {
        Browser_Factory.init_browser();

    }
    @Test
    public void Floating_Menu_test(){
        driver = Browser_Factory.init_url(floating_menu);
        floating_menu_page fmp  = PageFactory.initElements(driver, floating_menu_page.class);
        fmp.right_click_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//        driver = Browser_Factory.teardown();
   }
}
