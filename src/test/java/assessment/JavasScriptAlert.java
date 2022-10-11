package assessment;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import util.Driver;

public class JavasScriptAlert extends Driver {

    // could use TestNG soft assertions for these test cases and collect the results of the two assertions at the end of each test case.
    JavaScriptAlertsPage page = new JavaScriptAlertsPage(Driver.getDriver());

    @Test
    public void javascript_simple_alert_test() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        try {
            page.simpleAlertButton.click();
        } catch (NoAlertPresentException e) {
            Assert.fail("simple alert not present");
        }

        String expectedText = "I am a JS Alert";
        String actualText = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualText , expectedText , "simple alert message incorrect");

        Driver.getDriver().switchTo().alert().accept();

        // there is a typo on the site message should be "You successfully clicked an alert" -> successfully is misspelled
        expectedText = "You successfuly clicked an alert";
        actualText = page.result.getText();

        Assert.assertEquals(actualText , expectedText , "result message incorrect for simple alert interaction");
    }

    @Test
    public void javascript_confirmation_alert_test() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        try {
            page.confirmAlertButton.click();
        } catch (NoAlertPresentException e) {
            Assert.fail("confirmation alert not present");
        }

        String expectedText = "I am a JS Confirm";
        String actualText = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualText , expectedText , "confirmation alert incorrect");

        Driver.getDriver().switchTo().alert().accept();

        expectedText = "You clicked: Ok";
        actualText = page.result.getText();

        Assert.assertEquals(actualText , expectedText , "result message incorrect for confirmation alert acceptance");
    }

    @Test
    public void javascript_prompt_alert_test() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        try {
            page.promptAlertButton.click();
        } catch (NoAlertPresentException e) {
            Assert.fail("prompt alert not present");
        }

        String expectedText = "I am a JS prompt";
        String actualText = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualText , expectedText , "confirmation alert incorrect");

        expectedText = "Hello World!";

        Driver.getDriver().switchTo().alert().sendKeys(expectedText);
        Driver.getDriver().switchTo().alert().accept();

        expectedText = "You entered: " + expectedText;
        actualText = page.result.getText();

        Assert.assertEquals(actualText , expectedText , "result message incorrect for prompt alert interaction");
    }
}
