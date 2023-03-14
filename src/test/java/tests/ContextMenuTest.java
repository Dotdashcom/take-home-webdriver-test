package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ContextMenuTest {

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
    public void javaScriptOnRightClick() {

        String resultTextAlert = "You selected a context menu";
        String textAlert = "";

        driver.get(URL + "/context_menu");

        Actions action = new Actions(driver);

        try {
            WebElement link = driver.findElement(By.id("hot-spot"));

            // Right click the element
            action.contextClick(link).perform();

            textAlert = driver.switchTo().alert().getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

        assertEquals(resultTextAlert, textAlert);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
