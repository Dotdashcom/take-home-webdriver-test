package com.academy.techcenture;

import com.academy.techcenture.pages.CheckboxesPage;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseClassTest {

    @Test
    public void checkAllCheckboxes(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver,softAssert);
        checkboxesPage.navigateTo("/checkboxes");
        checkboxesPage.selectAllCheckboxes();
        checkboxesPage.unselectAllCheckboxes();
    }

}
