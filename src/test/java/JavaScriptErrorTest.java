import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;

class JavaScriptErrorTest {

    WebDriver driver;
    private final String url = "/javascript_error";

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void javaScriptErrorTest() throws IOException, URISyntaxException {

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

        boolean containsError = false;

        for (LogEntry log : logs) {
            if (log.toString().contains("Cannot read properties of undefined (reading 'xyz')")) {
                containsError = true;
            }
        }

        assert containsError;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}