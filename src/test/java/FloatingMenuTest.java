import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.time.Duration;

class FloatingMenuTest {

    WebDriver driver;

    private final String url = "/floating_menu";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void floatingMenuTest() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("menu"));

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(elementIsVisibleOnScreen(element));
        }  catch (TimeoutException e) {
            assert false;
        }

        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        try {
            wait.until(elementIsVisibleOnScreen(element));
        }  catch (TimeoutException e) {
            assert false;
        }

        assert true;
    }

    private ExpectedCondition<Boolean> elementIsVisibleOnScreen(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return isVisibleInViewport(element);
            }
        };
    }

    private Boolean isVisibleInViewport(WebElement element) {
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}