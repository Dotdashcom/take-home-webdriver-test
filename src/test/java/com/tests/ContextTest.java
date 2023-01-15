package com.tests;

import com.assignments.pages.CheckBoxPage;
import com.assignments.pages.ContextPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.CONTEXT_MENU;
import static org.testng.Assert.*;

public final class ContextTest extends BaseTest {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private ContextTest() {

  }
  @Test(description = "Validate alert Menu text by right clicking on Context Menu",
          testName = "Context Menu Alert Validation")
  public void validateContextMenu() {
    new HomePage().clickOnLink(CONTEXT_MENU);
    assertEquals(new ContextPage().clickContextMenu().testContextMenu(), "You selected a context menu");
  }
}
