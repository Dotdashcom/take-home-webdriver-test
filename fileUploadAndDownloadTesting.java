import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class fileUploadAndDownloadTesting {
    TestUtils testUtils = new TestUtils();
    WebDriver driver;
    Actions actions;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        actions = new Actions(driver);
    }

    @Test
    public  void fileDownloadTest(){
        driver.get(UrlConstants.File_Download);
        testUtils.download(driver, UrlConstants.Download_File_Text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File f = new File("C:\\Users\\developer1\\Downloads\\some-file.txt");
        assertTrue(f.exists());
        f.delete();
    }


    @Test
    public  void fileUploadByChooseFileTest(){
        driver.get(UrlConstants.File_Upload);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
                //driver.findElement(By.id("custom-input"));
        chooseFile.sendKeys("C:\\Users\\developer1\\Downloads\\upload-some-file.txt");
        testUtils.clickButton(driver,"button");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.findElement(By.className("example")).getText().contains("File Uploaded!"));
    }

    @Ignore
    @Test
    public  void fileUploadByDragTest(){
        driver.get(UrlConstants.File_Upload);
        driver.findElement(By.id(UrlConstants.Upload_File_Id)).sendKeys("C:\\Users\\developer1\\Downloads\\upload-some-file.txt");

        testUtils.clickButton(driver,"button");
        assertEquals("File Uploaded!", driver.findElement(By.className("example")).getText());
    }


    @AfterTest
    public void close(){
        driver.close();
    }
}
