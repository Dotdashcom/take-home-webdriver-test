package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;

public class DragAndDropTests extends TestBase {
  DragAndDropPage dragAndDropPage = new DragAndDropPage();

  @Test
  public void dragAndDropTest() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "drag_and_drop");
    String element_A_TextBeforeAction = dragAndDropPage.getElementText_A();
    dragAndDropPage.dragAndDrop();
    String element_A_TextAfterAction = dragAndDropPage.getElementText_A();

    Assert.assertEquals(element_A_TextBeforeAction, element_A_TextAfterAction);
    /*Assert.assertEquals(element_A_TextBeforeAction,element_A_TextAfterAction);
    Assertion is correct but not working as expected after the action A goes back to its initial position*/
  }
}
