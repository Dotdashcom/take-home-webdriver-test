package homework.tests;

import homework.pages.IframePage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeStepDef extends TestBase {

    IframePage iframePage=new IframePage();

    @Test
    public void iframe(){

        Driver.getDriver().get("http://localhost:7080/iframe");

        Driver.getDriver().switchTo().frame(iframePage.iframe);
        iframePage.textArea.sendKeys("Jelena");

        String expected="Jelena";

        Assert.assertTrue(expected.contains("Jelena"));


    }
}
