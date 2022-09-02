package Tests;

import org.junit.jupiter.api.Test;
import utilities.BrowserUtils;

import static Tests.TestBase.extentReports;
import static Tests.TestBase.extentTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicControlTest<extentTest, DynamicControlPage> {
    String baseURL="http://localhost:7080";

    @Test
    public void dynamicControl() {
        Pages.DynamicControlPage dcp = new Pages.DynamicControlPage();

        extentTest = extentReports.createTest("Dynamic Control");
        extentTest.info("Navigate Dynamic Control Page");
        //dcp.navigateTo(EndPoints.DYNAMICCONTROLS);

        //assertTrue(dynamicControl.checkBox.isDisplayed());
        extentTest.info("Assert That checkbox is Displayed");

        dcp.removeButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.goneMessage, 5);
        extentTest.info("Info Message is Displayed => " + dcp.checkboxGone.getText());

        assertTrue(dcp.checkboxGone.isDisplayed());
        extentTest.info("goneMessage is Displayed => " + dcp.goneMessage.getText());
        dcp.addButton.click();
        BrowserUtils.waitForVisibility(dcp.backMessage, 5);
        assertTrue(dcp.checkBox.isDisplayed());

        extentTest.info("Enable Button Has Been Clicked");
        dcp.enableDisableButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.enableMessage, 15);
        extentTest.info("Enable is Displayed => " + dcp.enableMessage.getText());
        assertEquals(dcp.enableMessage.getText(), "It's enabled!");

        extentTest.info("Disable Button Has Been Clicked");
        dcp.enableDisableButton.click();
        extentTest.info("Explicit Wait is Initializing...");
        BrowserUtils.waitForVisibility(dcp.disableMessage, 15);
        extentTest.info("Disable is Displayed => " + dcp.disableMessage.getText());

        assertEquals(dcp.disableMessage.getText(), "It's disabled!");
        extentTest.pass("Dynamic Control Test is Successful");
    }
}
