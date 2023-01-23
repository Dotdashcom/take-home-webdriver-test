package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.hovers_page;
import utils.Browser_Factory;

public class _13_Mouse_Hover_test {

    WebDriver driver;
    String hovers = "hovers";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void  Hover_test(){
        driver = Browser_Factory.init_url(hovers);
        hovers_page hp = PageFactory.initElements(driver, hovers_page.class);
        hp.hovers_page_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//       driver = Browser_Factory.teardown();
    }
}
