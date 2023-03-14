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

public class DynamicControlsTest {

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
    public void buttonRemove() {

        String resultTextExpected = "It's gone!";
        String textGotten;

        driver.get(URL + "/dynamic_controls");

        try {

            driver.findElement(By.xpath("//button[text()='Remove']")).click();

            WebElement waiter = new WebDriverWait(driver, 10)
                    .until(driver -> driver.findElement(By.id("message")));

            textGotten = waiter.getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            textGotten = "";
        }

        assertEquals(resultTextExpected, textGotten);

    }

    @Test
    public void buttonAdd() {

        String resultTextExpected = "It's back!";
        String textGotten;

        driver.get(URL + "/dynamic_controls");

        try {

            driver.findElement(By.xpath("//button[text()='Remove']")).click();
            driver.findElement(By.xpath("//button[text()='Add']")).click();

            WebElement waiter = new WebDriverWait(driver, 10)
                    .until(driver -> driver.findElement(By.id("message")));

            textGotten = waiter.getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            textGotten = "";
        }

        assertEquals(resultTextExpected, textGotten);

    }

    @Test
    public void buttonEnable() {

        String resultTextExpected = "It's enabled!";
        String textGotten;

        driver.get(URL + "/dynamic_controls");

        try {
            driver.findElement(By.xpath("//button[text()='Enable']")).click();

            WebElement waiter = new WebDriverWait(driver, 10)
                    .until(driver -> driver.findElement(By.id("message")));

            textGotten = waiter.getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            textGotten = "";
        }

        assertEquals(resultTextExpected, textGotten);

    }

    @Test
    public void buttonDisable() {

        String resultTextExpected = "It's disabled!";
        String textGotten;

        driver.get(URL + "/dynamic_controls");

        try {
            driver.findElement(By.xpath("//button[text()='Enable']")).click();
            driver.findElement(By.xpath("//button[text()='Disable']")).click();

            WebElement waiter = new WebDriverWait(driver, 10)
                    .until(driver -> driver.findElement(By.id("message")));

            textGotten = waiter.getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            textGotten = "";
        }

        assertEquals(resultTextExpected, textGotten);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
