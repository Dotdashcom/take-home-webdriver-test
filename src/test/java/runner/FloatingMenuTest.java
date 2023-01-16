package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class FloatingMenuTest extends TestBase {

  FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

  @Test
  public void testFloatingMenu() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "floating_menu");
    floatingMenuPage.scrollDownThePage();
    Assert.assertTrue(floatingMenuPage.buttonsAreVisibleWhileScrolling());

  }
}
