package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.pages.CheckBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Test_03_Checkbox extends TestBase {
    @Test
    public void checkbox_test() {

        CheckBoxPage checkBoxPage = new CheckBoxPage();
       checkBoxPage.navigatePages("Checkboxes");
        List<WebElement> allCheckBoxes = checkBoxPage.checkboxes;

        for (int i = 0; i < allCheckBoxes.size(); i++) {
            if (!allCheckBoxes.get(i).isSelected()) {
                allCheckBoxes.get(i).click();
            }
            Assertions.assertTrue(allCheckBoxes.get(i).isSelected());
        }

        for (int i = 0; i < allCheckBoxes.size(); i++) {
            if (allCheckBoxes.get(i).isSelected()) {
                allCheckBoxes.get(i).click();
            }
            Assertions.assertFalse(allCheckBoxes.get(i).isSelected());
        }

    }

}
