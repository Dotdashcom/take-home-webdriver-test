package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class CheckboxTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/checkboxes");
    }

    @Test
    public void checkboxState() {
        List<WebElement> list = Driver.getDriver().findElements(By.cssSelector("input[type='checkbox']"));
        String attr1 = list.get(0).getAttribute("checked");
        Assert.assertEquals(null, attr1);
        list.get(0).click();
        Assert.assertNotEquals(null, list.get(0).getAttribute("checked"));
    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
