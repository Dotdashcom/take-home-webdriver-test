package UploadFilePack;
import Main.Package.UploadFilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UploadFilePageTest {
    private WebDriver driver;
    private UploadFilePage uploadFilePage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/upload");
        UploadFilePage uploadFilePage = new UploadFilePage(driver);
    }

    @Test

    public void UploadFileTest() throws Exception {

driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\kurdb\\Downloads\\some-file.txt");
Thread.sleep(3000);

driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        WebElement MessageSuccess = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
String SuccessText1 = MessageSuccess.getText();
        System.out.println(SuccessText1);
        if (SuccessText1.equals("File Uploaded!")) {
            System.out.println("Congrats File is Uploaded");
        }else{
            System.out.println("Failed!");
        }

    }
    @After
    public void TearDown() {
        driver.quit();
    }
}
