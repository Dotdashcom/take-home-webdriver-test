package runner;

import base.TestBase;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class MouseHoverTest extends TestBase {
  MouseHoverPage mouseHoverPage = new MouseHoverPage();

  @Test
  public void testMouseHoverActions() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "hovers");
    mouseHoverPage.mouseHoverFirstImg();
    mouseHoverPage.mouseHoverSecondImg();
    mouseHoverPage.mouseHoverThirdImg();
  }


}
