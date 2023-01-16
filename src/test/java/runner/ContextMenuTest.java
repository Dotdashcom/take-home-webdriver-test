package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class ContextMenuTest extends TestBase {
  ContextMenuPage contextMenuPage = new ContextMenuPage();

  @Test
  public void testContextMenu() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "context_menu");
    contextMenuPage.rightClick();
    String expectedAlertMessage = "You selected a context menu";
    Assert.assertTrue(contextMenuPage.getJavaScriptAlertText().contains(expectedAlertMessage));
  }
}
