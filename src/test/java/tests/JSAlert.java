package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JSAlertPage;
import utilities.EndPoints;

public class JSAlert extends TestBase {


    @Test
    public void testJSAlert() {
        JSAlertPage jsap = new JSAlertPage();
        extentTest = extentReports.createTest("JavaScript Alert Test");
        jsap.navigateTo(EndPoints.JSALERTS);
        extentTest.info("Navigate to JavaScript Alerts Page");

        jsap.alertButton.click();
        extentTest.info("JavaScript Alert Button is clicked");

        Alert js = jsap.driver.switchTo().alert();

        Assert.assertEquals(js.getText(),"I am a JS Alert");
        extentTest.info("JavaScript Alert Button's Pop-up Text is confirmed");
        js.accept();
        extentTest.info("Clicked to OK on JavaScript Alert Pop-up");

        Assert.assertEquals(jsap.resultText.getText(),"You successfuly clicked an alert");
        extentTest.info("Result Text is confirmed For Alert Button");


        jsap.confirmButton.click();
        extentTest.info("JavaScript Confirm Button is clicked");
        Assert.assertEquals(js.getText(),"I am a JS Confirm");
        extentTest.info("JavaScript Confirm Button's Pop-up Text is confirmed");
        js.accept();
        extentTest.info("Clicked to OK on JavaScript Confirm Pop-up");

        Assert.assertEquals(jsap.resultText.getText(),"You clicked: Ok");
        extentTest.info("Result Text is confirmed For Confirm Button");

        jsap.confirmButton.click();
        extentTest.info("JavaScript Confirm Button is clicked Again");
        js.dismiss();
        extentTest.info("Clicked to Cancel on JavaScript Confirm Pop-up");

        Assert.assertEquals(jsap.resultText.getText(),"You clicked: Cancel");
        extentTest.info("Result Text is confirmed For Confirm Button for the Cancel Click");

        jsap.promptButton.click();
        extentTest.info("JavaScript Prompt Button is clicked");

        Assert.assertEquals(js.getText(),"I am a JS prompt");
        extentTest.info("JavaScript Prompt Button's Pop-up Text is confirmed'");

        js.sendKeys("Mehmet");
        extentTest.info("Typed 'Mehmet' to the Text Area");
        js.accept();
        extentTest.info("Clicked to OK on JavaScript Prompt Pop-up after Typing 'Mehmet'");

        Assert.assertEquals(jsap.resultText.getText(),"You entered: Mehmet");
        extentTest.info("Result Text is confirmed For Prompt Button After Typing 'Mehmet'");
        extentTest.pass("JavaScript Alerts Test is Successful");

    }
}
