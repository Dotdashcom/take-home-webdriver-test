package runner;

import base.TestBase;
import org.testng.annotations.Test;
import pages.IframePage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class IframeTest extends TestBase {
  IframePage iframePage=new IframePage();

  @Test
  public void testIframe(){
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "iframe");
    iframePage.switchToIframe();
    iframePage.writeTextIn();
  }
}
