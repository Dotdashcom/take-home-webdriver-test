package com.dotdash.scripts;

import com.dotdash.pages.DynamicControls;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class DynamicControlsTest extends BaseWebTest<DynamicControls> {

    @Test
    public void addAndRemoveCheckbox() {
        DynamicControls dynamicControlsPage = getInitialPage();
        dynamicControlsPage.addRemoveCheckbox("Remove");

        checkThat("Checkbox removed message is displayed", dynamicControlsPage.getCheckboxOperationMessage(), equalTo("It's gone!"));
        checkThat("Checkbox is removed", dynamicControlsPage.isCheckboxDisplayed(), is(false));

        dynamicControlsPage.addRemoveCheckbox("Add");

        checkThat("Checkbox is displayed", dynamicControlsPage.isCheckboxDisplayed(), is(true));
        checkThat("Checkbox added message is displayed", dynamicControlsPage.getCheckboxOperationMessage(), equalTo("It's back!"));
    }

    @Test
    public void enableAndDisableInputField() {

        //TODO Will fail need to change
        DynamicControls dynamicControlsPage = getInitialPage();
        dynamicControlsPage.enableDisableInput("Enable");

        checkThat("Input enabled message is displayed", dynamicControlsPage.getInputOperationMessage(), equalTo("It's enabled!"));
        checkThat("Input is enabled", dynamicControlsPage.isInputEnabled(), is(true));

        dynamicControlsPage.enableDisableInput("Disable");

        checkThat("Input is disabled", dynamicControlsPage.isInputEnabled(), is(false));
        checkThat("Checkbox added message is displayed", dynamicControlsPage.getInputOperationMessage(), equalTo("It's disabled!"));
    }
}
