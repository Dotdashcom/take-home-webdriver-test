package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.DynamicLoadingPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DynamicLoadingTests extends BaseTest {

    @Test
    public void shouldSeeHelloWorld() {
        DynamicLoadingPage dynamicLoadingPage = GeneratePage
                .dynamicLoadingPage()
                .goToDynamicLoadingPage()
                .clickStartButton();

        assertThat(dynamicLoadingPage.getText(), is("Hello World!"));
    }
}
