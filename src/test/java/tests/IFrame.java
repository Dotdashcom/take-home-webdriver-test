package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.IFramePage;
import utilities.BrowserUtils;
import utilities.EndPoints;

public class IFrame extends TestBase {


    @Test
    public void testIFrame() {
        IFramePage ifp = new IFramePage();
        extentTest = extentReports.createTest("iFrame Test");
        ifp.navigateTo(EndPoints.IFRAME);
        extentTest.info("Navigate to iFrame Page");

        ifp.driver.switchTo().frame(ifp.targetFrame);
        String expectedText= "Your content goes here.";
        String actualText = ifp.inputArea.getText();

        Assert.assertEquals(actualText, expectedText);
        extentTest.info("inputArea is same as Expected => "+ifp.inputArea.getText());
        BrowserUtils.wait(2);

        ifp.inputArea.clear();
        BrowserUtils.wait(2);
        extentTest.info("inputArea is Cleared");

        ifp.inputArea.sendKeys("Mehmet Emin Tan");
        extentTest.info("'Mehmet Emin Tan' is Written to inputArea");

        Assert.assertEquals( ifp.inputArea.getText(),"Mehmet Emin Tan");
        extentTest.info("inputArea is Same As like Sent Keys => "+ifp.inputArea.getText());

        ifp.driver.switchTo().defaultContent();
        extentTest.info("iFrame Switched to Default Content");
        extentTest.pass("iFrame Test is Successful");



    }
}
