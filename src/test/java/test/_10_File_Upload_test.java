package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.upload_page;
import utils.Browser_Factory;

public class _10_File_Upload_test {

    WebDriver driver;
    String upload = "upload";
    @BeforeClass
    public void browser_fact_before() {
        Browser_Factory.init_browser();

    }
    @Test
    public void Upload_test() throws InterruptedException {
        driver = Browser_Factory.init_url(upload);
        upload_page up = PageFactory.initElements(driver, upload_page.class);
        up.File_Upload_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//        driver = Browser_Factory.teardown();
    }
}
