package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.JavaScriptErrorPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class JavaScriptErrorTests extends BaseTest {

    @Test
    public void shouldValidateError() {
        JavaScriptErrorPage javaScriptErrorPage = GeneratePage
                .javaScriptErrorPage()
                .goToJavaScriptErrorPage();

        assertThat(javaScriptErrorPage.getErrorLog(), is("Cannot read properties of undefined (reading 'xyz')"));
    }
}
