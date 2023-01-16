package runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenInNewTabPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class OpenInNewTabTest {
  OpenInNewTabPage openInNewTabPage=new OpenInNewTabPage();

  @Test
  public void testNewTab(){
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "windows");
    String expTitle="New Window";
    String actTitle=openInNewTabPage.switchToNewTab();
    Assert.assertEquals(expTitle,actTitle);
    String text=openInNewTabPage.getText();
    String expText="New Window";
    Assert.assertTrue(text.contains(expText));



  }
}
