package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DragAndDropTest {

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
    public void DragAndDrop() {

        String expectedOrder = "BA";
        String getOrder = "";

        driver.get(URL + "/drag_and_drop");

        Actions action = new Actions(driver);

        try {
            WebElement fromElement = driver.findElement(By.id("column-a"));
            WebElement toElement = driver.findElement(By.id("column-b"));


            Action dragAndDrop = action.clickAndHold(fromElement)
                    .moveByOffset(20, 10)
                    .moveToElement(toElement)
                    .release()
                    .build();

             dragAndDrop.perform();
             Thread.sleep(2000);

             List<WebElement> elements = driver.findElements(By.cssSelector("div[id='columns']>div"));
            for (WebElement element : elements) {
                getOrder += element.getText();
            }

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
            getOrder = "";
        }

        assertEquals(expectedOrder,getOrder);
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
