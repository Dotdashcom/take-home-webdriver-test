package JavaSc;

import Pages.JavaScriptAlertsPage;
import Pages.MouseHoverPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class JavaScriptAlertsTest extends TestBase {

    JavaScriptAlertsPage ja = new JavaScriptAlertsPage();

    @BeforeClass
    public void loginUrl() {
        driver.get(TestBase.BASEURL.concat("/javascript_alerts"));
    }

    @Test
    public void JavaScriptAlertstest() {
        ja.clickjsbutton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.dismiss();
    }

    @Test
    public void confirmAlerttest() {
        ja.confirmbutton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
    }

    @Test
    public void promptAlerttest() throws InterruptedException {
        String text = "test";
        ja.promptbutton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        Assert.assertTrue(ja.alerttext.getText().contains(text));
    }
}
