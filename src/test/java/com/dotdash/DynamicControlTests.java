package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.DynamicControlPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DynamicControlTests extends BaseTest {

    @Test
    public void shouldRemoveAndAddCheckbox() {
        DynamicControlPage dynamicControlPage = GeneratePage.dynamicControlPage().goToDynamicControlPage().clickCheckboxSwapButton();

        assertThat(dynamicControlPage.isCheckboxNotPresent(), is(true));

        dynamicControlPage.clickCheckboxSwapButton();

        assertThat(dynamicControlPage.isCheckboxPresent(), is(true));
    }

    @Test
    public void shouldEnableAndDisableButton() {
        DynamicControlPage dynamicControlPage = GeneratePage.dynamicControlPage().goToDynamicControlPage().clickTextFieldSwapButton();

        assertThat(dynamicControlPage.isTextFieldEnabled("It's enabled!"), is(true));

        dynamicControlPage.clickTextFieldSwapButton();

        assertThat(dynamicControlPage.isTextFieldEnabled("It's disabled!"), is(false));
    }
}
