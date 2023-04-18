import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContextMenuPage;
import util.Constants;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContextMenuTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ ContextMenuPage.url);
    }

    @Test
    void rightClickTest() {

        Actions actions = new Actions(driver);
        WebElement rightClickBox = driver.findElement(By.id("hot-spot"));
        actions.contextClick(rightClickBox).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            wait.until(ExpectedConditions.alertIsPresent());
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