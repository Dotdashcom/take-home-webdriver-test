package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class IframeTest {

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

        String resultTextExpected = "Your content goes here.";
        String textGotten;

        driver.get(URL + "/iframe");

        try {

            WebElement button = driver.findElement(By.cssSelector("div.tox-notifications-container>div>button"));
            button.click();

            driver.switchTo().frame("mce_0_ifr");

            textGotten = driver.findElement(By.cssSelector("iframe>html>body>p")).getText();

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            textGotten = "";
        }

        assertEquals(resultTextExpected,textGotten);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
