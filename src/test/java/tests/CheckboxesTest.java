package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class CheckboxesTest {
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
    public void HaveNotSelectedCheckbox() {

        driver.get(URL + "/checkboxes");

        try {
            List<WebElement> unCheckedBoxList = driver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));

            if (CollectionUtils.isEmpty(unCheckedBoxList))
                Assert.fail();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

    }

    @Test
    public void HaveSelectedCheckbox() {

        driver.get(URL + "/checkboxes");

        try {
            Thread.sleep(60);
            List<WebElement> checkedBoxList = driver.findElements(By.cssSelector("input:checked[type='checkbox']"));

            if (CollectionUtils.isEmpty(checkedBoxList))
                Assert.fail();
        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }

}