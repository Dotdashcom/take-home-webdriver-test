package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileUpload extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/upload";
    private WebElement choseFile;
    private WebElement fileSubmit;
    private String path = "/Users/andriionishchuk/Desktop/manimage.jpg";

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        choseFile = driver.findElement(By.id("file-upload"));
        fileSubmit = driver.findElement(By.id("file-submit"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void uploadFile() throws IOException, InterruptedException {

        choseFile.sendKeys(path);
        fileSubmit.click();

        String confirmationText = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();

        Assert.assertEquals(confirmationText,"File Uploaded!");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
