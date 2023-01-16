package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContent;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class DynamicContentTest extends TestBase {
  DynamicContent dynamicContent = new DynamicContent();

  @Test
  public void testDynamicContents() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "dynamic_content");
    String textBeforeRefresh = dynamicContent.getFirstContextText();
    dynamicContent.refreshPage();
    String textAfterRefresh = dynamicContent.getFirstContextText();
    Assert.assertNotEquals(textBeforeRefresh, textAfterRefresh);
    String text2 = dynamicContent.getSecondContextText();
    dynamicContent.refreshPage();
    String text3 = dynamicContent.getSecondContextText();
    Assert.assertNotEquals(text2, text3);
  }
}
