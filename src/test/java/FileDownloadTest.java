import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

class FileDownloadTest {

    WebDriver driver;
    private final String url = "/download";
    String downloadDefaultDirectory;

    @BeforeEach
    void setUp() {
        downloadDefaultDirectory = System.getProperty("user.dir") + File.separator +
                "ChromeDriver" + File.separator +
                "BrowserDownloadedFiles";
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory",downloadDefaultDirectory);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void fileDownloadTest() throws IOException, URISyntaxException {
        WebElement contentDiv = driver.findElement(By.id("content"));
        WebElement downloadLink = contentDiv.findElement(By.tagName("a"));

        String fileName =  Paths.get(new URI(downloadLink.getAttribute("href"))
                .getPath()).getFileName().toString();

        String filePath = downloadDefaultDirectory+"/"+fileName;

        File f = new File(filePath);
        Files.deleteIfExists(f.toPath());

        downloadLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(filePresent(filePath));
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    public ExpectedCondition<Boolean> filePresent(String filePath) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                File f = new File(filePath);
                return f.exists();
            }
        };
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}