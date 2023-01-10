package tests;

import model.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.BaseUtils;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void testRemoveCheckboxButtonCheckboxNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .isCheckboxNotDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxResultMessageText() {
        String expectedResult = "It's gone!";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .getAddRemoveCheckboxResultMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testRemoveCheckboxButtonCheckboxDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .clickAndWaitAddRemoveCheckboxButton()
                .isCheckboxDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testTextAreaIsEnabled() {
        boolean isTextAreaEnabled =  new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .isTextAreaEnabled();

        Assert.assertTrue(isTextAreaEnabled);
    }

    @Test
    public void testTextAreaIsDisabled() {
        boolean isTextAreaDisabled =  !new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .clickAndWaitEnableDisableTextAreaButton()
                .isTextAreaEnabled();

        Assert.assertTrue(isTextAreaDisabled);
    }

    @Test
    public void testEnableDisableTextAreaResultMessageText() {
        String expectedResult = "It's enabled!";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .getEnableDisableTextAreaResultMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testIsCheckboxFunctioning() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage();

        boolean checkboxStatusBeforeClick = dynamicControlsPage.isCheckboxSelected();
        boolean checkboxStatusAfterClick = dynamicControlsPage.clickCheckbox().isCheckboxSelected();

        Assert.assertNotEquals(checkboxStatusBeforeClick, checkboxStatusAfterClick);

        checkboxStatusBeforeClick = checkboxStatusAfterClick;
        checkboxStatusAfterClick = dynamicControlsPage.clickCheckbox().isCheckboxSelected();

        Assert.assertNotEquals(checkboxStatusBeforeClick, checkboxStatusAfterClick);
    }

    @Test
    public void testAddRemoveCheckboxWaitbarImageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAddRemoveCheckboxButton()
                .isAddRemoveCheckboxWaitbarImageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxWaitbarImageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .isAddRemoveCheckboxWaitbarImageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxLoadingMessageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAddRemoveCheckboxButton()
                .isAddRemoveCheckboxLoadingMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxLoadingMessageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .isAddRemoveCheckboxLoadingMessageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxLoadingMessageText() {
        String expectedResult = "Wait for it...";
        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAddRemoveCheckboxButton()
                .getAddRemoveCheckboxLoadingMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAddRemoveCheckboxResultMessageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .isAddRemoveCheckboxResultMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxResultMessageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAddRemoveCheckboxButton()
                .isAddRemoveCheckboxResultMessageNotDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddRemoveCheckboxButtonTextRemove() {
        String expectedResult = "Remove";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .getAddRemoveCheckboxButtonText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAddRemoveCheckboxButtonTextAdd() {
        String expectedResult = "Add";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .getAddRemoveCheckboxButtonText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCheckboxNotChangingLocation_testToFail() {
        boolean checkboxChangedLocation = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitAddRemoveCheckboxButton()
                .clickAndWaitAddRemoveCheckboxButton()
                .isCheckboxChangedLocationToButton();

        Assert.assertFalse(checkboxChangedLocation, "This test fails. Ask me at the interview");
    }

    @Test
    public void testTextAreaFunctioning() {
        String inputText = BaseUtils.getRandomString();
        String expectedResult = inputText;

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .inputTextAreaText(inputText)
                .getTextFromTextArea();

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void testEnableDisableTextAreaWaitbarImageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickEnableDisableTextAreaButton()
                .isEnableDisableTextAreaWaitbarImageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testEnableDisableTextAreaWaitbarImageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .isEnableDisableTextAreaWaitbarImageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testEnabledDisabledTextAreaLoadingMessageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickEnableDisableTextAreaButton()
                .isEnableDisableTextAreaLoadingMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testEnableDisableTextAreaLoadingMessageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .isEnableDisableTextAreaLoadingMessageDisplayed();

        Assert.assertFalse(actualResult);
    }

    @Test
    public void testEnableDisableTextAreaLoadingMessageText() {
        String expectedResult = "Wait for it...";
        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickEnableDisableTextAreaButton()
                .getEnableDisableTextAreaLoadingMessageText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testEnableDisableTextAreaResultMessageDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .isEnableDisableTextAreaResultMessageDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testEnableDisableTextAreaResultMessageNotDisplayed() {
        boolean actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickEnableDisableTextAreaButton()
                .isEnableDisableTextAreaResultMessageNotDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testEnableDisableTextAreaButtonTextEnable() {
        String expectedResult = "Enable";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .getEnableDisableButtonText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testEnableDisableTextAreaButtonTextDisable() {
        String expectedResult = "Disable";

        String actualResult = new DynamicControlsPage(getDriver())
                .getDynamicControlsPage()
                .clickAndWaitEnableDisableTextAreaButton()
                .getEnableDisableButtonText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}