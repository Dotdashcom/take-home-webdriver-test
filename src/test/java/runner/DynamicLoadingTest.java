package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoading;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class DynamicLoadingTest extends TestBase {
  DynamicLoading dynamicLoading = new DynamicLoading();

  @Test
  public void testDynamicLoading() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "dynamic_loading/2");
    dynamicLoading.clickOnStartButton();
    Assert.assertTrue(dynamicLoading.getTextIsDisplayed());
  }
}
