package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.DropdownPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropdownTests extends BaseTest {

    @Test
    public void shouldSelectFirstOption() {
        DropdownPage dropdownPage = GeneratePage.dropdownPage().goToDropdownPage().selectOption("1");

        assertThat(dropdownPage.getSelectedOption(), is("Option 1"));
    }

    @Test
    public void shouldSelectSecondOption() {
        DropdownPage dropdownPage = GeneratePage.dropdownPage().goToDropdownPage().selectOption("2");

        assertThat(dropdownPage.getSelectedOption(), is("Option 2"));
    }
}
