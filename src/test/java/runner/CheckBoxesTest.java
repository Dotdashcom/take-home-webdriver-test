package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class CheckBoxesTest extends TestBase {
  CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

  @Test
  public void checkBoxesTests() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "checkboxes");
    //check if check boxes are displayed
    Assert.assertTrue(checkBoxesPage.checkbox1IsDisplayed());
    Assert.assertTrue(checkBoxesPage.checkbox2IsDisplayed());
    //check that checkbox 2 is selected by default
    Assert.assertTrue(checkBoxesPage.checkbox2IsSelected());
    checkBoxesPage.selectCheckBox1();
    Assert.assertTrue(checkBoxesPage.checkbox1IsSelected());
    checkBoxesPage.selectCheckBox2();
    Assert.assertFalse(checkBoxesPage.checkbox2IsSelected());


  }
}
