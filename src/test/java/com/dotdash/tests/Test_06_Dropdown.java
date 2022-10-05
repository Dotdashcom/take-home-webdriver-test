package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.DropDownPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;


public class Test_06_Dropdown extends TestBase {
    @Test
public void dropdown_test() {

            DropDownPage dropDownPage = new DropDownPage();
            dropDownPage.navigatePages("Dropdown");

            Select select = new Select(dropDownPage.dropDown);
            select.selectByVisibleText("Option 1");

            Assertions.assertEquals("Option 1", select.getFirstSelectedOption().getText());

            select.selectByVisibleText("Option 2");

            Assertions.assertEquals("Option 2", select.getFirstSelectedOption().getText());

        }
}
