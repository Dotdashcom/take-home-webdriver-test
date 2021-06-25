package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlPage;
import utilities.BrowserUtils;
import utilities.EndPoints;


public class DynamicControl extends TestBase {


    @Test
    public void testDynamicControl() {

        DynamicControlPage dcp = new DynamicControlPage();

        extentTest = extentReports.createTest("Dynamic Control");
        extentTest.info("Navigate Dynamic Control Page");
        dcp.navigateTo(EndPoints.DYNAMICCONTROLS);

        Assert.assertTrue(dcp.checkBox.isDisplayed());
        extentTest.info("Assert That checkbox is Displayed");

        dcp.removeButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.goneMessage,5);
        extentTest.info("Info Message is Displayed => " + dcp.checkboxGone.getText());

        Assert.assertTrue(dcp.checkboxGone.isDisplayed());
        extentTest.info("goneMessage is Displayed => " + dcp.goneMessage.getText());
        dcp.addButton.click();
        BrowserUtils.waitForVisibility(dcp.backMessage,5);
        Assert.assertTrue(dcp.checkBox.isDisplayed());

        extentTest.info("Enable Button Has Been Clicked");
        dcp.enableDisableButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.enableMessage,15);
        extentTest.info("Enable is Displayed => " + dcp.enableMessage.getText());
        Assert.assertEquals(dcp.enableMessage.getText(),"It's enabled!");

        extentTest.info("Disable Button Has Been Clicked");
        dcp.enableDisableButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.disableMessage,15);
        extentTest.info("Disable is Displayed => " + dcp.disableMessage.getText());

        Assert.assertEquals(dcp.disableMessage.getText(),"It's disabled!");
        extentTest.pass("Dynamic Control Test is Successful");










    }
}
