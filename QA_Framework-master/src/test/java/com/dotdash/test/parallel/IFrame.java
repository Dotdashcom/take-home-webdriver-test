package com.dotdash.test.parallel;

import com.dotdash.pageobject.IFramePage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrame extends BaseTest {

    private IFramePage iframe_page = null;

    @BeforeMethod
    void init() {
        if (iframe_page == null) iframe_page = new IFramePage(driver);
    }

    @Test
    void able_to_input_text_to_iframe() {
        iframe_page
                .input_text_in_Iframe("ABC")
                .verify_input_text();
    }

}
