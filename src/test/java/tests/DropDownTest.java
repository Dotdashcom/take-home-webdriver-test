package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DropDownTest {

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
    public void dropDownTestingOp1() {

        String resultTextExpected = "Option 1";
        String resultText = "";

        driver.get(URL + "/dropdown");

        try {

            Select drpList = new Select(driver.findElement(By.id("dropdown")));

            drpList.selectByValue("1");

            resultText = drpList.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            resultText = "";
        }

        assertEquals(resultTextExpected, resultText);

    }

    @Test
    public void dropDownTestingOp2() {

        String resultTextExpected = "Option 2";
        String resultText = "";

        driver.get(URL + "/dropdown");


        Actions action = new Actions(driver);

        try {
            Thread.sleep(120);

            Select drpList = new Select(driver.findElement(By.id("dropdown")));

            drpList.selectByValue("2");

            resultText = drpList.getFirstSelectedOption().getText();
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
