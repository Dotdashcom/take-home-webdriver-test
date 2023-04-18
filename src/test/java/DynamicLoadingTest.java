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

import java.time.Duration;

class DynamicLoadingTest {

    WebDriver driver;
    static String url = "/dynamic_loading/2";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void dynamicLoadingTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startButton = driver.findElement(By.tagName("button"));

        startButton.click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
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