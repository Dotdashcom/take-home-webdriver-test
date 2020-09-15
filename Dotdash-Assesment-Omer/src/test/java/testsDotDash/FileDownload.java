package testsDotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class FileDownload {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/download");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void fileDownloadTest(){
        WebElement DownloadButton = Driver.get().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        DownloadButton.click();
        String fileName = DownloadButton.getText();
        System.out.println("fileName = " + fileName);
        String filePath ="/Users/tarik/Downloads/some-file.txt";
        System.out.println("filePath = " + filePath);

    }

}
