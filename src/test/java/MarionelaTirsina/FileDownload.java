package MarionelaTirsina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FileDownload {
    @Before
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/download");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
//File Download: http://localhost:7080/download Test File Download.
    @Test
    public void fileDownloadTest(){
        WebElement fileToDownload = Driver.get().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        fileToDownload.click();
        String fileName = fileToDownload.getText();
        System.out.println("fileName = " + fileName);
        String filePath ="/Users/metinkaya/Downloads/some-file.txt";
        System.out.println("filePath = " + filePath);

    }

}
