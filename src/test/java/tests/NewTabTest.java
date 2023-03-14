package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class NewTabTest {

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

        String expectedResult = "New Window";
        String gottenResult;

        driver.get(URL + "/windows");

        try {
            driver.findElement(By.xpath("//a[text()='Click Here']")).click();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); //switches to new tab

            gottenResult = driver.findElement(By.cssSelector("div.example")).getText();
            System.out.println(gottenResult);
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            gottenResult = "";
        }

        assertEquals(expectedResult,gottenResult);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
