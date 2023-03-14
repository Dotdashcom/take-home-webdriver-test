package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DynamicLoadingTest {

    private static WebDriver driver;
    private static String URL = "";

    @Before
    public void beforeStart() {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        URL = RunEnvironment.getUrlBase();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dynamicLoading() {

        String resultTextExpected = "Hello World!";
        String resultText;

        driver.get(URL + "/dynamic_loading/2");

        try {
            WebElement button = driver.findElement(
                    By.cssSelector("button"));

            button.click();

            WebElement waiter = new WebDriverWait(driver, 10)
                    .until(driver -> driver.findElement(By.id("finish")));

            resultText = waiter.getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultText = "";
        }

        assertEquals(resultTextExpected, resultText);

    }
    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
