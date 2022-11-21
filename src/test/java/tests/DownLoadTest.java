package tests;

import Pages.DownLoad_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DownLoadTest  {
    public String downloadUrl="download";
    WebDriver driverDotDash;
    DownLoad_Page downLoad_page;
    @Before
    public void setUp(){
        downLoad_page=new DownLoad_Page(driverDotDash);
        downLoad_page.setChrome();
        downLoad_page.setUrl(downloadUrl);
    }

    @Test
    public void downloadinProgess() throws InterruptedException {
        downLoad_page.downloadFile();
    }

    @After
    public void tearDown() {

        downLoad_page.closeAllWindows();
    }
}
