package com.dotdash.scripts;

import com.dotdash.pages.IFrame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class IFrameTest extends BaseWebTest<IFrame> {

    @Test
    public void iFrameInputText() {
        IFrame iFramePage = getInitialPage();

        iFramePage.enterText("Hello World");

        checkThat("Typing in IFrame input works as expected", iFramePage.getInputText(), equalTo("Hello World"));
    }
}
