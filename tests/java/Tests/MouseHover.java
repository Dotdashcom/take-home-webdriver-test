package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void MouseHover() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().get("http://localhost:7080/hovers");
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 1; i <= 3; i++) {
            actions.moveToElement(Driver.getDriver().findElement(By.xpath
                            ("(//img[@src='/img/avatar-blank.jpg'])" + "[" + i + "]"))).
                    build().perform();
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//h5)" + "[" + i + "]")).isDisplayed());
        }
    }
}
