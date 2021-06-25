package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.EndPoints;


public class ContextMenu extends TestBase {


    @Test
    public void testContextMenu() {
        ContextMenuPage cmp = new ContextMenuPage();
        extentTest = extentReports.createTest("Context Menu");
        extentTest.info("Navigate To Context Menu Page");
        cmp.navigateTo(EndPoints.CONTEXTMENU);
        cmp.rightClickOnHotSpot();
        extentTest.info("Right Click on Hotspot");
        String message = cmp.getAlertMessage();
        extentTest.info("AlertMessage is Appeared");

        Assert.assertEquals(message,"You selected a context menu");
        extentTest.info("Alert Menu Text is Verified");
        extentTest.pass("Context Menu Test is Successful ");

    }
}
