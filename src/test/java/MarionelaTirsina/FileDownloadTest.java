package MarionelaTirsina;

import MarionelaTirsina.pages.FileDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FileDownloadTest {
    FileDownload fileDownload=new FileDownload();
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/download");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void fileDownloadTest(){
        WebElement fileToDownload =fileDownload.downloader;
        fileToDownload.click();
        String actualFileName = fileToDownload.getText();
        String expectedFileName="some-file.txt";
        Assert.assertEquals(actualFileName, expectedFileName);

    }
    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);

    }

}
