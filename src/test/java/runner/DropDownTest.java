package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class DropDownTest extends TestBase {

  DropDownPage dropDownPage = new DropDownPage();

  @Test
  public void testDropDownMenu() throws InterruptedException {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "dropdown");
    dropDownPage.dropDownMenu();
    dropDownPage.selectOption1();
    Assert.assertTrue(dropDownPage.option1IsSelected());
    dropDownPage.selectOption2();
    Assert.assertTrue(dropDownPage.option2IsSelected());

  }

}
