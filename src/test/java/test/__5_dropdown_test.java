package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dropdown_page;
import utils.Browser_Factory;

public class __5_dropdown_test {

    WebDriver driver;
    String dropdown = "dropdown";
    @BeforeClass
    public void browser_fact_before() {
      driver =  Browser_Factory.init_browser();

    }
    @Test
    public void dropdown_test() throws InterruptedException {
        driver = Browser_Factory.init_url(dropdown);
        dropdown_page dwp = PageFactory.initElements(driver, dropdown_page.class);
        dwp.Drop_Down_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//     driver =   Browser_Factory.teardown();
    }
}