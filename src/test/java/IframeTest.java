import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;

class IframeTest {

    WebDriver driver;
    private final String url = "/iframe";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void iframeTest() throws IOException, URISyntaxException {

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement iframeBody = driver.findElement(By.id("tinymce"));

        iframeBody.clear();

        String testText = "Hello World";

        iframeBody.sendKeys(testText);

        if (iframeBody.getText().equals(testText))
            assert true;
        else
            assert false;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}