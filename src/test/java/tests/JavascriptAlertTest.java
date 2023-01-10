package tests;

import model.JavascriptAlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class JavascriptAlertTest extends BaseTest {

    final String textToEnter = BaseUtils.getRandomString();

    @Test
    public void testJSAlertIsDisplayed() {
        boolean actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSAlertButton()
                .isAlertPresent();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testJSAlertText() {
        String expectedResult = "I am a JS Alert";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSAlertButton()
                .getTextJSAlert();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSAlertIsNotDisplayed() {
        boolean actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSAlertButton()
                .clickOKJSAlert()
                .isAlertPresent();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testJSAlertActionConfirmation() {
        String expectedResult = "You successfuly clicked an alert";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSAlertButton()
                .clickOKJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSConfirmText() {
        String expectedResult = "I am a JS Confirm";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSConfirmButton()
                .getTextJSAlert();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSConfirmAlertActionConfirmationOK() {
        String expectedResult = "You clicked: Ok";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSConfirmButton()
                .clickOKJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSConfirmAlertActionConfirmationCancel() {
        String expectedResult = "You clicked: Cancel";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSConfirmButton()
                .clickCancelJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSPromptText() {
        String expectedResult = "I am a JS prompt";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSPromptButton()
                .getTextJSAlert();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSPromptAlertActionConfirmationOK() {
        String expectedResult = "You entered: " + textToEnter;

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSPromptButton()
                .inputTextJSAlert(textToEnter)
                .clickOKJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSPromptAlertActionConfirmationOKNoTextEntry() {
        String expectedResult = "You entered:";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSPromptButton()
                .clickOKJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSPromptAlertActionConfirmationCancelNoTextEntry() {
        String expectedResult = "You entered: null";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSPromptButton()
                .clickCancelJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testJSPromptAlertActionConfirmationCancel() {
        String expectedResult = "You entered: null";

        String actualResult = new JavascriptAlertPage(getDriver())
                .getJavascriptAlertPage()
                .clickJSPromptButton()
                .clickCancelJSAlert()
                .getAlertActionConfirmationMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}