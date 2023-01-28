package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/dropdown");
    }

    @Test
    public void dropdown() {
        Select dd = new Select(Driver.getDriver().findElement(By.cssSelector("#dropdown")));
        dd.selectByVisibleText("Option 1");
        Assert.assertEquals(dd.getFirstSelectedOption().getText(), "Option 1");
        dd.selectByVisibleText("Option 2");
        Assert.assertEquals(dd.getFirstSelectedOption().getText(), "Option 2");

    }

    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }

}
