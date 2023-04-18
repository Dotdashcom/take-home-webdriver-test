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

class JavaScriptAlertsTest {

    WebDriver driver;
    private final String url = "/javascript_alerts";

    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void alertButtonTest() throws IOException, URISyntaxException {

        Actions action = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));

        alertButton.click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());

            if (!driver.switchTo().alert().getText().equals("I am a JS Alert")) {
                assert false;
            }
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    @Test
    void confirmButtonTest() throws IOException, URISyntaxException {

        WebElement confirmButton = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));

        confirmButton.click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());

            if (!driver.switchTo().alert().getText().equals("I am a JS Confirm")) {
                assert false;
            }
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    @Test
    void promptButtonTest() throws IOException, URISyntaxException {

        WebElement promptButton = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));

        promptButton.click();

        String alertInput = "Hello World";

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().sendKeys(alertInput);
            driver.switchTo().alert().accept();
            if (!driver.findElement(By.id("result")).getText().equals("You entered: " + alertInput)) {
                assert false;
            }
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