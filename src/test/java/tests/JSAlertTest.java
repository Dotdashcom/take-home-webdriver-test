package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class JSAlertTest {

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
    public void jsAlertButton() {

        String resultExpected = "You successfuly clicked an alert";
        String resultGotten;


        driver.get(URL + "/javascript_alerts");

        try {
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

            driver.switchTo().alert().accept();

            resultGotten = driver.findElement(By.id("result")).getText();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultGotten = "";

        }

        assertEquals(resultExpected,resultGotten);

    }

    @Test
    public void jsOkConfirmButton() {

        String resultExpected = "You clicked: Ok";
        String resultGotten;


        driver.get(URL + "/javascript_alerts");

        try {
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

            driver.switchTo().alert().accept();

            resultGotten = driver.findElement(By.id("result")).getText();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultGotten = "";

        }

        assertEquals(resultExpected,resultGotten);

    }

    @Test
    public void jsCancelConfirmButton() {

        String resultExpected = "You clicked: Cancel";
        String resultGotten;


        driver.get(URL + "/javascript_alerts");

        try {
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

            driver.switchTo().alert().dismiss();

            resultGotten = driver.findElement(By.id("result")).getText();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultGotten = "";

        }

        assertEquals(resultExpected,resultGotten);

    }

    @Test
    public void jsPromptButton() {


        String textEntered = "Text in prompt for test";
        String resultExpected = "You entered: "+textEntered;
        String resultGotten;


        driver.get(URL + "/javascript_alerts");

        try {
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

            driver.switchTo().alert().sendKeys(textEntered);
            driver.switchTo().alert().accept();

            resultGotten = driver.findElement(By.id("result")).getText();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultGotten = "";

        }

        assertEquals(resultExpected,resultGotten);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
