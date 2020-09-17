package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTests extends TestBase {
    String url="download";

    @Test
    public void fileDownload() throws InterruptedException {
        Driver.setUp(url);
        WebElement txtFile=Driver.getDriver().findElement(By.cssSelector("#content>div>a"));
        txtFile.click();
        Thread.sleep(5000);
        String userFolder=System.getProperty("user.home");
        String path=userFolder+"/Downloads/test.txt";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
