package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class DropDownPage {
    String dropDown="//select[@id='dropdown']";

    public void clickAndSelect(String option){
        I.amPerforming().click(dropDown);
        I.amPerforming().dropDown(dropDown).selectByVisibleText(option);
    }

    public void assertDropDownOptionSelection(String option){
        Assert.assertTrue(I.amPerforming().isSelected(dropDown+"//option[text()='"+option+"']"));
    }
}
