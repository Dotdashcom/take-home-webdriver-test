package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_008_DynamicControls extends CommonMethods {

    String resText;

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/dynamic_controls ");
    }

    @Test
    public void TC001_DynamicControlsTesting() {
        dc.addRemoveBtn().click();
        visibleOfElements(dc.respondText());
        resText = dc.respondText().getText();
        Assert.assertTrue(resText.contains("gone"));

        dc.addRemoveBtn().click();
        visibleOfElements(dc.respondText());
        resText = dc.respondText().getText();
        Assert.assertTrue(resText.contains("back"));
        Assert.assertTrue(dc.getCheckBox().isDisplayed());
        Assert.assertTrue(dc.getCheckBox().isEnabled());

        dc.enableDisableBtn().click();
        visibleOfElements(dc.respondText());
        resText = dc.respondText().getText();
        Assert.assertTrue(resText.contains("enabled"));
        Assert.assertTrue(dc.getTextBox().isEnabled());

        dc.enableDisableBtn().click();
        visibleOfElements(dc.respondText());
        resText = dc.respondText().getText();
        Assert.assertTrue(resText.contains("disabled"));
        Assert.assertFalse(dc.getTextBox().isEnabled());
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
