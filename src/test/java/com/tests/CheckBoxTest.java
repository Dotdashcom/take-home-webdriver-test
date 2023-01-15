package com.tests;

import com.assignments.pages.CheckBoxPage;
import com.assignments.pages.HomePage;
import com.assignments.pages.LoginPage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.CHECKBOXES;
import static com.assignments.enums.ConfigProperties.PASSWORD;
import static com.assignments.enums.ConfigProperties.USERNAME;
import static com.assignments.utils.PropertyUtils.getValue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public final class CheckBoxTest extends BaseTest {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private CheckBoxTest() {

  }
  @Test(description = "Validate the check and uncheck function of Checkbox",
          testName = "Checkbox Functionality validation")
  public void validCheckbox() {
    new HomePage().clickOnLink(CHECKBOXES);
    CheckBoxPage check = new CheckBoxPage();
    check.clickOnCheckBox1();
    assertTrue(check.isCheckBox1Selected());
    check.clickOnCheckBox1();
    assertFalse(check.isCheckBox1Selected());
    check.clickOnCheckBox2();
    assertFalse(check.isCheckBox2Selected());
    check.clickOnCheckBox2();
    assertTrue(check.isCheckBox2Selected());
  }
}
