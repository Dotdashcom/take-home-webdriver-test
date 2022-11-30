package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.IframePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IframeTests extends BaseTest {

    @Test
    public void shouldBeAbleToTypeOnIframe() {
        IframePage iframePage = GeneratePage
                .iframePage()
                .goToIframePage()
                .writeToIframe();

        assertThat(iframePage.getIframeText(), is("IFRAME TEST"));
    }
}
