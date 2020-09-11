package QatestsMatif;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class FileDownload {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/download");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void fileDownloadTest(){
        WebElement fileToDownload = Driver.get().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        fileToDownload.click();
        String fileName = fileToDownload.getText();
        System.out.println("fileName = " + fileName);
        String filePath ="C:\\text\\";
        System.out.println("filePath = " + filePath);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }

}
