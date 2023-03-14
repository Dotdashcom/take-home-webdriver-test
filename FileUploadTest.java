package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest extends BaseTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "http://localhost:7080/upload";
        driver.get(baseUrl);
    }

    @Test
    public void testFileUpload() {
        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        // Path to the file to be uploaded
        uploadElement.sendKeys("Path");
        WebElement submitButton = driver.findElement(By.id("file-submit"));
        submitButton.click();
        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals("testfile.txt", uploadedFiles.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
