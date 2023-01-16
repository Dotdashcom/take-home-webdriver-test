package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

import static org.testng.Assert.fail;

public class DynamicControlsTests extends TestBase {
  DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

  @Test
  public void testDynamicControls() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "dynamic_controls");
    Assert.assertTrue(dynamicControlsPage.removeCheckboxIsVisible());
    dynamicControlsPage.clickOnRemove();
    String actualMsg = dynamicControlsPage.getTextMessage();
    String expectedMsg = "It's gone!";
    if (!actualMsg.contains(expectedMsg)) {
      fail();
    }
    dynamicControlsPage.clickOnAddButton();
    Assert.assertTrue(dynamicControlsPage.addCheckboxIsVisible());
    String expMsg = "It's back!";
    String actMsg = dynamicControlsPage.getTextMessage();
    Assert.assertEquals(expMsg, actMsg);

    dynamicControlsPage.clickOnEnableButton();
    String expTextMsg = "It's enabled!";
    String actTextMsg = dynamicControlsPage.getTextMessage();
    Assert.assertEquals(expTextMsg, actTextMsg);

    dynamicControlsPage.clickOnDisableButton();
    String expDisableTextMsg = "It's disabled!";
    String actDisableTextMsg = dynamicControlsPage.getDisableTextMessage();
    if (!actDisableTextMsg.contains(expDisableTextMsg)) {
      fail();
    }


  }
}
