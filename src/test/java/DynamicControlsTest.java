import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

class DynamicControlsTest {

    WebDriver driver;
    static String url = "/dynamic_controls";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void removeAddButtonTest() {
        WebElement checkboxExample = driver.findElement(By.id("checkbox-example"));
        WebElement button = checkboxExample.findElement(By.tagName("button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        button.click();

        By findCheckbox = By.id("checkbox");

        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findCheckbox)));
        }  catch (TimeoutException e) {
            assert false;
        }

        button.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(findCheckbox));
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    @Test
    void enableDisableButtonTest() {
        WebElement inputExample = driver.findElement(By.id("input-example"));
        WebElement button = inputExample.findElement(By.tagName("button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By findInput = By.tagName("input");
        WebElement inputElement = inputExample.findElement(findInput);

        button.click();

        try {
            wait.until((ExpectedCondition<Boolean>) driver -> inputElement.isEnabled());
        }  catch (TimeoutException e) {
            assert false;
        }

        button.click();

        try {
            wait.until((ExpectedCondition<Boolean>) driver -> !inputElement.isEnabled());
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