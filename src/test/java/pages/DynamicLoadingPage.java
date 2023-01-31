package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {
    @FindBy(tagName = "h3")
    private WebElement dynamicLoadingPageTitle;

    @FindBy(tagName = "button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement dynamicMessage;

    public DynamicLoadingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void assertDynamicLoadingBehavior(String expectedMessage) {
        startButton.click();
        waitForElementToBeVisible(dynamicMessage);
        Assertions.assertFalse(startButton.isDisplayed());
        Assertions.assertEquals(expectedMessage, dynamicMessage.getText());
    }

    public void assertPageTitle(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, dynamicLoadingPageTitle.getText());
    }

    @Override
    public void assertElementsAreDisplayed() {
        Assertions.assertTrue(dynamicLoadingPageTitle.isDisplayed());
        Assertions.assertTrue(startButton.isDisplayed());
    }
}
