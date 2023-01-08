package tests;

import model.IframePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class IframeTest extends BaseTest {

    final String textToEnter = BaseUtils.getRandomString();

    @Test
    public void testTextBoxInputText() {
        String expectedResult = textToEnter;

        String actualResult = new IframePage(getDriver())
                .getIframePage()
                .closeNotification()
                .switchToIframe()
                .clearAndInputTextInTextBox(textToEnter)
                .getTextFromTextBox();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testFormatTextBoldPartially() {
        int numberOfCharactersToFormat = 3;
        String expectedFormat = "strong";

        String enteredText = new IframePage(getDriver())
                .getIframePage()
                .closeNotification()
                .switchToIframe()
                .clearAndInputTextInTextBox(textToEnter)
                .highlightPartialText(numberOfCharactersToFormat)
                .switchToParentFrame()
                .clickBoldButton()
                .switchToIframe()
                .getEnteredTextByNumberOfChars(numberOfCharactersToFormat);

        String actualFormat = new IframePage(getDriver())
                .getFormattingOfSelectedText(enteredText);
        Assert.assertEquals(actualFormat, expectedFormat);
    }

    @Test
    public void testMakeAllTextBold() {
        String expectedResult = "strong";

        String actualResult = new IframePage(getDriver())
                .getIframePage()
                .closeNotification()
                .switchToIframe()
                .clearAndInputTextInTextBox(textToEnter)
                .highlightAllText()
                .switchToParentFrame()
                .clickBoldButton()
                .switchToIframe()
                .getAttributeOfText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}