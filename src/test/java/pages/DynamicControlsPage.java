package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {
    private static final String CHECKBOX_REMOVAL_MESSAGE = "It's gone!";
    private static final String CHECKBOX_APPEARANCE_MESSAGE = "It's back!";
    private static final String ENABLE_INPUT_MESSAGE = "It's enabled!";
    private static final String DISABLE_INPUT_MESSAGE = "It's disabled!";

    @FindBy(tagName = "h4")
    private WebElement dynamicControlsPageTitle;

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    private WebElement checkBoxControlButton;

    @FindBy(xpath = "//form[@id='input-example']/button")
    private WebElement inputControlButton;

    @FindBy(id = "checkbox")
    private WebElement checkBox;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textInput;

    @FindBy(xpath = "//form[@id='checkbox-example']/p")
    private WebElement dynamicCheckBoxMessage;

    @FindBy(xpath = "//form[@id='input-example']/p")
    private WebElement dynamicInputMessage;

    public DynamicControlsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void assertInputEnable() {
        inputControlButton.click();
        waitUntilElementIsClickable(textInput);
        Assertions.assertEquals(ENABLE_INPUT_MESSAGE, dynamicInputMessage.getText());
    }

    public void assertInputDisable() {
        inputControlButton.click();
        waitUntilElementIsNotClickable(textInput);
        Assertions.assertEquals(DISABLE_INPUT_MESSAGE, dynamicInputMessage.getText());
    }

    public void assertCheckBoxAppearance() {
        checkBoxControlButton.click();
        waitForElementToBeVisible(checkBox);
        Assertions.assertEquals(CHECKBOX_APPEARANCE_MESSAGE, dynamicCheckBoxMessage.getText());
    }

    public void assertCheckBoxRemoval() {
        checkBoxControlButton.click();
        waitForElementToBeInvisible(checkBox);
        Assertions.assertEquals(CHECKBOX_REMOVAL_MESSAGE, dynamicCheckBoxMessage.getText());
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, dynamicControlsPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(dynamicControlsPageTitle.isDisplayed());
        Assertions.assertTrue(checkBox.isDisplayed());
        Assertions.assertTrue(textInput.isDisplayed());
        Assertions.assertTrue(checkBoxControlButton.isDisplayed());
        Assertions.assertTrue(inputControlButton.isDisplayed());
    }
}
