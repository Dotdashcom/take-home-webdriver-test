package specs.DynamicLoading;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #9 Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits
public class CheckDynamicLoading extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 3000;
    private static WebDriverWait wait;
    private static By byStart = By.xpath("//div[@id='start']/button");
    private static By byResult = By.id("finish");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/dynamic_loading/2");
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void checkHelloWorld() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        Thread.sleep(DEFAULT_PAUSE);

        // Start loading
        driver.findElement(byStart).click();

        String actText = "";

        try {
            WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(byResult));
            actText = helloWorld.getText();
        } catch (TimeoutException e) {
            System.out.println("Hello World still doesn't exist");
        }

        // Validate Hello World text
        softas.assertTrue(actText.equals("Hello World!"), "Hello World still doesn't exist");

        softas.assertAll();
    }
}
