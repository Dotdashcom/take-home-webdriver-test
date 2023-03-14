package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class FloatingMenuTest {

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
    public void isDisplayedFM() {

        boolean isDisplayed = false;

        driver.get(URL + "/floating_menu");

        try {

            isDisplayed = driver.findElement(By.id("menu")).isDisplayed();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

        assertTrue(isDisplayed);

    }

    @After
    public void tearDown() {

        EnvironmentManager.shutDownDriver();
    }
}
