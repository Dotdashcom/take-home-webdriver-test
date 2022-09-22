package com.dotdash.tests;

import com.dotdash.pages.DropDownPage;
import com.dotdash.pages.TestBase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;


public class DropDownTest extends TestBase {

    @Test
    public void dropDownTest() {

        DropDownPage dropDownPage = new DropDownPage();
        dropDownPage.navigatePages("Dropdown");

        Select select = new Select(dropDownPage.dropDown);
        select.selectByVisibleText("Option 1");

        Assertions.assertEquals("Option 1", select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 2");

        Assertions.assertEquals("Option 2", select.getFirstSelectedOption().getText());

    }


}
