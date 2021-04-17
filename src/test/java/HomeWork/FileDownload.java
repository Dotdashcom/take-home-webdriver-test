package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileDownload extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/download";
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws IOException {

        driver = initializeDriver();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver,3);
    }

    @Test
    public void downloadFile() throws InterruptedException {


       WebElement fileToDownload = driver.findElement(By.linkText("some-file.txt"));
       wait.until(ExpectedConditions.elementToBeClickable(fileToDownload)).click();


       File downloadedFile = new File("/Users/andriionishchuk/Downloads/some-file.txt");
       Thread.sleep(1000);

       if(downloadedFile.exists()){
           Assert.assertTrue(downloadedFile.exists());

           downloadedFile.delete();
       }





    }





    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
