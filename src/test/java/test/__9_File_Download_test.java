package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.download_page;
import utils.Browser_Factory;

import java.io.IOException;

public class __9_File_Download_test {
    WebDriver driver;
    String download = "download";
    @BeforeClass
    public void browser_fact_before() {
       driver = Browser_Factory.init_browser();

    }
    @Test
    public void download_test() throws IOException, InterruptedException {
        driver = Browser_Factory.init_url(download);
        download_page dp = PageFactory.initElements(driver, download_page.class);
        dp.File_Download_meth();
    }
    @AfterClass
    public void browser_fact_After () throws InterruptedException {
//       driver =  Browser_Factory.teardown();
    }
}