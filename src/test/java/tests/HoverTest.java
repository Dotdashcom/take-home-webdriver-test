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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HoverTest {

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
    public void hoverTest() {

        String expectedResult = "http://localhost:7080/users/1";
        String gottenResult;

        driver.get(URL + "/hovers");

        Actions action = new Actions(driver);

        try {
            List<WebElement> listDivs = driver.findElements(
                    By.cssSelector("div.example>div"));

            for (WebElement element : listDivs)
            {
                action.moveToElement(element).perform();
                Thread.sleep(2000);
            }

            WebElement firstHoverElement = listDivs.get(0);

            action.moveToElement(firstHoverElement).perform();
            WebElement divActive =  driver.findElement(By.cssSelector("div.figcaption>a"));

            gottenResult = divActive.getAttribute("href");

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
