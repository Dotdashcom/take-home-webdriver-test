package com.dotdash.scripts;

import com.dotdash.pages.DynamicLoading;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class DynamicLoadingTest extends BaseWebTest<DynamicLoading> {

    @Test
    public void dynamicLoadMessageDisplayed() {
        DynamicLoading dynamicLoadingPage = getInitialPage();
        dynamicLoadingPage.start();

        checkThat("Hello World message is displayed", dynamicLoadingPage.isHelloWorldMessageDisplayed(), is(true));
    }
}
