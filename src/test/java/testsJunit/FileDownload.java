package testsJunit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

import java.io.File;

public class FileDownload extends BaseClass  {
    //I am on the File Download page
    //I click on the file
    //I assert that the file is downloaded

    @Test
    public void i_am_on_the_File_Download_page() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/download");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().findElement(By.xpath("//a[text()='some-file.txt']")).click();
        Thread.sleep(2000);


    }


    }

