package com.dotdash.scripts;

import com.dotdash.pages.Dropdown;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class DropdownTest extends BaseWebTest<Dropdown> {

    @Test
    public void selectOptionsFromDropdown() {
        String option = "Option 1";
        Dropdown dropdownPage = getInitialPage();
        dropdownPage.selectOption(option);

        checkThat(option + " is selected", dropdownPage.isOptionSelected(option), is(true));

        option = "Option 2";
        dropdownPage.selectOption(option);

        checkThat(option + " is selected", dropdownPage.isOptionSelected(option), is(true));
    }
}
