package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownload extends TestBase {

    @Test
    public void fileDownloadTest() throws Exception {

        driver.get(baseUrl+"/download");


        WebElement fileDownloadLink = driver.findElement(By.xpath("//a[.='some-file.txt']"));
        fileDownloadLink.click();

        Assert.assertTrue(isFileDownload());

    }

    public boolean isFileDownload() throws Exception{
        final int SLEEP_TIME_MILLIS = 1000;
        File file = new File("C:\\Users\\semih\\Downloads");
        final int timeout = 60* SLEEP_TIME_MILLIS;
        int timeElapsed = 0;
        while (timeElapsed<timeout){
            if (file.exists()) {
                System.out.println( "some-file.txt" + " is present");
                return true;
            } else {
                timeElapsed +=SLEEP_TIME_MILLIS;
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        }
        return false;
    }
}
