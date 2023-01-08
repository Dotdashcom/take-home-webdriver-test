package tests;

import model.JavascriptErrorPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class JavascriptErrorTest extends BaseTest {

    @Test
    public void testJavascriptErrorIsPresent() {
        boolean actualResult = new JavascriptErrorPage(getDriver())
                .getJavascriptErrorPage()
                .isJavascriptError();

        Assert.assertTrue(actualResult);
    }
    @Test
    public void testJavascriptErrorText() {
        String expectedResult = "Cannot read properties of undefined (reading 'xyz')";

        List<String> actualResult = new JavascriptErrorPage(getDriver())
                .getJavascriptErrorPage()
                .getJavascriptErrorsTextList();

        Assert.assertTrue(actualResult.stream().anyMatch(element->element.contains(expectedResult)));
    }
}