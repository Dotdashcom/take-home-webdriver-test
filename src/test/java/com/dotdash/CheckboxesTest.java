package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.CheckboxPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckboxesTest extends BaseTest {

    @Test
    public void mustCheckAndUncheckFirstCheckbox() throws InterruptedException {
        CheckboxPage checkboxPage = GeneratePage
                .checkboxPage()
                .goToCheckboxPage()
                .clickCheckbox("first checkbox");

        assertThat(checkboxPage.getCheckbox("first checkbox").isSelected(), is(true));

        checkboxPage.clickCheckbox("first checkbox");

        assertThat(checkboxPage.getCheckbox("first checkbox").isSelected(), is(false));
    }

    @Test
    public void mustCheckAndUncheckSecondCheckbox() throws InterruptedException {
        CheckboxPage checkboxPage = GeneratePage
                .checkboxPage()
                .goToCheckboxPage()
                .clickCheckbox("second checkbox");

        assertThat(checkboxPage.getCheckbox("second checkbox").isSelected(), is(false));

        checkboxPage.clickCheckbox("second checkbox");

        assertThat(checkboxPage.getCheckbox("second checkbox").isSelected(), is(true));
    }
}
