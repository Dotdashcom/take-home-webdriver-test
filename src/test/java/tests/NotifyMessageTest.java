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

public class NotifyMessageTest {

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
    public void newTab() {

        boolean isDisplayed;

        driver.get(URL + "/notification_message_rendered");

        try {
            driver.findElement(By.xpath("//a[text()='Click here']")).click();

            isDisplayed = driver.findElement(By.id("flash-messages")).isDisplayed();
            System.out.println(isDisplayed);
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            isDisplayed = false;
        }

        assertTrue(isDisplayed);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
