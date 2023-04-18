import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

class FileUploadTest {

    WebDriver driver;
    private final String url = "/upload";
    String downloadDefaultDirectory;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void fileUploadTest() throws IOException, URISyntaxException {

        WebElement browse = driver.findElement(By.id("file-upload"));
        browse.sendKeys(this.getClass().getResource("some-file.txt").getPath());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("file-submit")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files")));
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}