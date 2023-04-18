import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

class MouseHoverTest {

    WebDriver driver;
    private final String url = "/hovers";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void mouseHoverTest() throws IOException, URISyntaxException {

        List<WebElement> figuresList = driver.findElements(By.className("figure"));

        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement figure : figuresList) {
            action.moveToElement(figure).perform();
            WebElement figCaption = figure.findElement(By.className("figcaption"));
            WebElement figCaptionText = driver.findElement(
                    By.xpath("//*[text()='"+figCaption.findElement(By.tagName("h5")).getText()+"']")
            );
            try {
                wait.until(ExpectedConditions.visibilityOf(figCaptionText));
            }  catch (TimeoutException e) {
                assert false;
            }
        }

        assert true;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}