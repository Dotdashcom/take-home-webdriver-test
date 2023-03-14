package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DynamicContentTest {

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
    public void dynamicContent() {

        String text1 = "";
        String dynamicText1 = "";
        boolean isDiferent = false;

        driver.get(URL + "/dynamic_content");

        try {
            List<WebElement> listDivs = driver.findElements(
                    By.cssSelector("div[class='large-10 columns']"));

            for (WebElement div : listDivs) {
                text1 += div.getText();
            }

            driver.navigate().refresh();

            listDivs = driver.findElements(
                    By.cssSelector("div[class='large-10 columns']"));

            for (WebElement div : listDivs) {
                dynamicText1 += div.getText();
            }

            if (!text1.equals(dynamicText1)) {
                isDiferent = true;
            }

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

        assertTrue(isDiferent);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
