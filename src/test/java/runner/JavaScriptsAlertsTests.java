package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class JavaScriptsAlertsTests extends TestBase {
  JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

  @Test
  public void testAlerts() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "javascript_alerts");
    javaScriptAlertsPage.clickOnJsAlertButton();
    String actAlertMsg = javaScriptAlertsPage.getJsAlertText();
    String expAlertMsg = "I am a JS Alert";
    Assert.assertEquals(actAlertMsg, expAlertMsg);

    javaScriptAlertsPage.clickOnJsConfirmButton();
    String actConfirmAlertMsg = javaScriptAlertsPage.getJsConfirmText();
    String expConfirmAlertMsg = "I am a JS Confirm";
    Assert.assertEquals(actConfirmAlertMsg, expConfirmAlertMsg);

    javaScriptAlertsPage.clickOnJsPromptButton();
    String actPromptAlertMsg = javaScriptAlertsPage.getJsPromptText();
    String expPromptAlertMsg = "You entered: Ali";
    Assert.assertEquals(actPromptAlertMsg, expPromptAlertMsg);


  }
}
