package com.dotdash.pageObject;

import com.framework.libraries.BrowserBucket;
import com.framework.libraries.I;
import org.testng.Assert;

public class CheckBoxesPage {

    private String checkBox = "input[@type='checkbox']";

    public void clickOnCheckBox(String optionName){
        I.amPerforming().click(checkBoxLocator(optionName));
    }

    public void assertCheckBoxChecked(String optionName){
        Assert.assertTrue(I.amPerforming().isSelected(checkBoxLocator(optionName)));
    }

    public void assertCheckBoxUnChecked(String optionName){
        Assert.assertTrue(!I.amPerforming().isSelected(checkBoxLocator(optionName)));
    }

    private String checkBoxLocator(String optionName){
        return "//text()[contains(.,'"+optionName+"')]//preceding-sibling::input[@type='checkbox'][1]";
    }
}
