package com.dotdash.scripts;

import com.dotdash.pages.Checkbox;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CheckboxTest extends BaseWebTest<Checkbox> {

    @Test
    public void checkAndUncheckAllOptions() {
        Checkbox checkboxPage = getInitialPage().checkAll();

        checkThat("All options are checked", checkboxPage.allChecked(), is(true));

        checkboxPage.uncheckAll();

        checkThat("All options are unchecked", checkboxPage.allUnchecked(), is(true));
    }
}
