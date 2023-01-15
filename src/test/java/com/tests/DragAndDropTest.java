package com.tests;

import com.assignments.pages.ContextPage;
import com.assignments.pages.DragAndDropPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import java.awt.*;

import static com.assignments.constants.LinkNameConstants.DRAG_AND_DROP;
import static org.testng.Assert.assertEquals;

public final class DragAndDropTest extends BaseTest {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private DragAndDropTest() {

  }
  @Test(description = "Validate drag and drop functionality",
          testName = "Drag and Drop Validation")
  public void validateDragAndDrop() {
    new HomePage().clickOnLink(DRAG_AND_DROP);
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    String beforeSwappingColumnAText = dragAndDropPage.getElementAText();
    String beforeSwappingColumnBText = dragAndDropPage.getElementBText();
    dragAndDropPage.dragAndDropAction();
    String afterSwappingColumnAText = dragAndDropPage.getElementAText();
    String afterSwappingColumnBText = dragAndDropPage.getElementBText();

    assertEquals(beforeSwappingColumnAText, afterSwappingColumnBText);
    assertEquals(beforeSwappingColumnBText, afterSwappingColumnAText);
  }
}
