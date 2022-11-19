package com.dotdash.scripts;

import com.dotdash.pages.JavascriptError;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class JavascriptErrorTest extends BaseWebTest<JavascriptError> {

    @Test
    public void validateJsErrorDisplayed() {
        String expectedErrorMessage = "Cannot read properties of undefined (reading 'xyz')";
        checkThat("The JS error " + expectedErrorMessage + " is displayed", getInitialPage().isLogPresent(expectedErrorMessage), is(true));
    }
}
