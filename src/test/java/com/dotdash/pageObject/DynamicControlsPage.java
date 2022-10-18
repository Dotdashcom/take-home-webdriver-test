package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class DynamicControlsPage {
    String checkBox = "//input[@id='checkbox']";
    String input = "//form[@id='input-example']//input[@type='text']";

    public enum controls {
        Add,
        Remove,
        Enable,
        Disable;
    }

    public void clickControls(String addOrRemove) {
        I.amPerforming().click("//button[text()='" + addOrRemove + "']");
    }

    public void assertControlsAdded() {
        Assert.assertTrue(I.amPerforming().isDisplayed(checkBox));
    }

    public void assertControlsRemove() {
        boolean flag = false;

        try {
            I.amPerforming().isDisplayed(checkBox);
        } catch (NoSuchElementException noSuchElementException) {
            flag = true;
        }

        Assert.assertTrue(flag);
    }

    public void assertControlsEnable() {
        Assert.assertTrue(I.amPerforming().isDisplayed(input));
    }

    public void assertControlsDisable() {
        Assert.assertTrue(I.amPerforming().isDisplayed(input+"[@disabled]"));
    }

}
